// package com.example.landingapp.controller;
// import com.example.landingapp.model.User;
// import com.example.landingapp.service.UserService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController
// @RequestMapping("/api/auth")
// @CrossOrigin(origins = "*")
// public class AuthController {
//   private final UserService userService;
//   public AuthController(UserService s){ this.userService = s; }

//   @PostMapping("/signup")
//   public ResponseEntity<?> signup(@RequestBody Map<String,String> body){
//     try {
//       User u = userService.register(body.get("name"), body.get("email"), body.get("password"));
//       return ResponseEntity.ok(Map.of("id", u.getId(), "email", u.getEmail()));
//     } catch(Exception e){
//       return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
//     }
//   }

//   @PostMapping("/login")
//   public ResponseEntity<?> login(@RequestBody Map<String,String> body){
//     var opt = userService.login(body.get("email"), body.get("password"));
//     if(opt.isPresent()){
//       User u = opt.get();
//       // for now, return simple user info (no JWT). Add JWT in next iteration.
//       return ResponseEntity.ok(Map.of("id",u.getId(),"name",u.getName(),"email",u.getEmail()));
//     } else {
//       return ResponseEntity.status(401).body(Map.of("message","Invalid credentials"));
//     }
//   }
// }
















































// package com.example.landingapp.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import com.example.landingapp.model.User;
// import com.example.landingapp.service.UserService;

// @RestController
// @RequestMapping("/api/auth")
// @CrossOrigin(origins = "*")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     // @PostMapping("/signup")
//     // public ResponseEntity<?> registerUser(@RequestBody User user) {
//     //     User savedUser = userService.registerUser(user);
//     //     return ResponseEntity.ok(savedUser);
//     // }

//     @PostMapping("/signup")
// public ResponseEntity<String> registerUser(@RequestBody User user) {
//     try {
//             User newUser = userService.registerUser(user);
//             return ResponseEntity.ok(newUser);
//         } catch (Exception e) {
//             return ResponseEntity.badRequest().body("Error: " + e.getMessage());
//         }
// }


//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody User user) {
//         User u = userService.login(user.getEmail(), user.getPassword());
//         if (u != null) {
//             return ResponseEntity.ok(u);
//         } else {
//             return ResponseEntity.status(401).body("Invalid credentials");
//         }
//     }
// }














































package com.example.landingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.landingapp.model.User;
import com.example.landingapp.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User newUser = userService.registerUser(user);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
              e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User u = userService.login(user.getEmail(), user.getPassword());
        if (u != null) {
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
