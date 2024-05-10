package com.example.lab6_20190271.Controller;

import com.example.lab6_20190271.Entity.Technician;
import com.example.lab6_20190271.Repository.TechnicianRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/tecnico")
public class TecnicoController {

    final TechnicianRepository technicianRepository;

    public TecnicoController(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;

    }

    @GetMapping(value = {"", "/"})
    public String listaProductos(Model model) {
        model.addAttribute("listaTecnicos", technicianRepository.findAll());
        return "product/list";
    }

    @GetMapping("/new")
    public String nuevoTechnicianFrm(Model model, @ModelAttribute("technician") Technician technician) {
        return "tecnico/editFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("product") @Valid Technician technician, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal

            if (technician.getFirstname().equals("Brenda")) {
                model.addAttribute("msg", "Error al crear tecnico");
                return "product/editFrm";
            } else {
                if (technician.getId() == 0) {
                    attr.addFlashAttribute("msg", "Tecnico"+technician.getFirstname() +technician.getLastname()+ "creado exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "Tecnico" +technician.getFirstname() +technician.getLastname()+"actualizado exitosamente");
                }
                technicianRepository.save(technician);
                return "redirect:/product";
            }

        } else {
            return "product/editFrm";
        }
    }

    @GetMapping("/edit")
    public String editarTransportista(@ModelAttribute("technician") Technician technician,
                                      Model model, @RequestParam("TechnicianID") int idtechnician) {

        Optional<Technician> optTechnician = technicianRepository.findById(idtechnician);

        if (optTechnician.isPresent()) {
            technician = optTechnician.get();
            model.addAttribute("technician", technician);
            return "product/editFrm";
        } else {
            return "redirect:/product";
        }
    }


}
