package com.oasis.onlinereservationsystem.controller;

import com.oasis.onlinereservationsystem.model.Reservation;
import com.oasis.onlinereservationsystem.model.User;
import com.oasis.onlinereservationsystem.service.ReservationService;
import com.oasis.onlinereservationsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeController {


    private ReservationService reservationService;
    private UserService userService;

    // handle login page request
    @GetMapping("/login")
    public String sendLogin(){
        return "login";
    }

    // handle login details and redirect to index page
    @PostMapping("/login")
    public String login(@ModelAttribute("user")User user, Model model){
        boolean usernameAndPasswordExist = userService.isUsernameAndPasswordExist(user.getUsername(), user.getPassword());
        if(usernameAndPasswordExist){
            return "index";
        }
        model.addAttribute("error", "Incorrect Username or Password");
        return "login";
    }

    // handle cancel ticket request
    @PostMapping("/cancel-ticket")
    public String ticket(@ModelAttribute("reservation") Reservation reservation, Model model){
        Reservation reservation1 = reservationService.findByPnrNumber(reservation.getPnr());
        if(reservation1 != null){
            model.addAttribute("reservation", reservation1);
            return "cancel-ticket";
        }
        model.addAttribute("error", "Cannot find any reservation, Please check PNR number!");
        return "cancel-ticket";
    }

    // handle cancel ticket confirmation
    @PostMapping("/confirm-cancel")
    public String confirmCancel(){
        return "booked";
    }

    // handle reservation page request
    @GetMapping("/reservation")
    public String reservation(Model model){
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "reservation";
    }

    // handle cancel ticket form request
    @GetMapping("/cancel-form")
    public String cancel(){
        return "cancel-ticket";
    }

    // handle index page request
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    // handle book ticket request submitted by user
    @PostMapping("/reservation/book")
    public String insert(@ModelAttribute("reservation") Reservation reservation,
                         BindingResult result,
                         Model model){
        if(result.hasErrors()){
            model.addAttribute("reservation", reservation);
            return "/reservation";
        }
        reservationService.newReservation(reservation);

        return "booked";
    }
}
