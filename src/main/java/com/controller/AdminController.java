// package com.example.landingapp.controller;
// import com.example.landingapp.model.Admin;
// import com.example.landingapp.model.User;
// import com.example.landingapp.repository.AdminRepository;
// import com.example.landingapp.service.UserService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCrypt;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/admin")
// @CrossOrigin(origins = "*")
// public class AdminController {
//   private final AdminRepository adminRepo;
//   private final UserService userService;
//   public AdminController(AdminRepository ar, UserService us){ this.adminRepo=ar; this.userService=us; }

//   @PostMapping("/login")
//   public ResponseEntity<?> login(@RequestBody Map<String,String> body){
//     var opt = adminRepo.findByEmail(body.get("email"));
//     if(opt.isPresent() && BCrypt.checkpw(body.get("password"), opt.get().getPasswordHash())){
//       // simplified token — produce proper JWT/oauth later
//       return ResponseEntity.ok(Map.of("token","admin-simple-token","email",opt.get().getEmail()));
//     }
//     return ResponseEntity.status(401).body(Map.of("message","Invalid admin credentials"));
//   }

//   @GetMapping("/users")
//   public ResponseEntity<List<User>> users(){ return ResponseEntity.ok(userService.findAll()); }

//   @DeleteMapping("/users/{id}")
//   public ResponseEntity<?> removeUser(@PathVariable Long id){
//     userService.deleteById(id);
//     return ResponseEntity.ok(Map.of("message","deleted"));
//   }

//   @PutMapping("/users/{id}")
//   public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Map<String,String> body){
//     var updated = userService.update(id, body.get("name"), body.get("email"));
//     return ResponseEntity.ok(updated);
//   }
// }































package com.example.landingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.landingapp.model.User;
import com.example.landingapp.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Add endpoints for edit/remove later
}
