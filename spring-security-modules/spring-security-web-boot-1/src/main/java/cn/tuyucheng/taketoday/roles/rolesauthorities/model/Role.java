package cn.tuyucheng.taketoday.roles.rolesauthorities.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @ManyToMany(mappedBy = "roles")
   private Collection<User> users;

   @ManyToMany
   @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
   private Collection<Privilege> privileges;

   private String name;

   public Role() {
   }

   public Role(String name) {
      this.name = name;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Collection<User> getUsers() {
      return users;
   }

   public void setUsers(Collection<User> users) {
      this.users = users;
   }

   public Collection<Privilege> getPrivileges() {
      return privileges;
   }

   public void setPrivileges(Collection<Privilege> privileges) {
      this.privileges = privileges;
   }

   @Override
   public int hashCode() {
      int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      Role role = (Role) obj;
      return role.equals(role.name);
   }

   @Override
   public String toString() {
      return "Role [name=" + name + "]" + "[id=" + id + "]";
   }
}