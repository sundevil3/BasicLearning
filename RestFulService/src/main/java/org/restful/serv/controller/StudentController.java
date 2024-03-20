package org.restful.serv.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.restful.serv.dao.StudentDAO;
import org.restful.serv.model.Student;
/*import org.vik.rest.model.User;*/

@Path("/StudentService")
public class StudentController {
    StudentDAO studentDAO = new StudentDAO();

    @GET
    @Path("/students")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }


    @POST
    @Path("/addStudent")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> addStudent(Student student) {
        boolean status = studentDAO.addStudent(student);
        System.out.println("Student creation Status :"+status);
        return studentDAO.getAllStudents();
    }

    @PUT
    @Path("/student/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> updateStudent(@PathParam("id") int id, Student student) {

        boolean status = studentDAO.upateStudent(student.getId(), student.getName(), student.getAge());
        System.out.println("Student update Status :"+status);
        return studentDAO.getAllStudents();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> updateStudent(Student student) {

        boolean status = studentDAO.upateStudent(student.getId(), student.getName(), student.getAge());
        System.out.println("Student update Status :"+status);
        return studentDAO.getAllStudents();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Student> deleteStudent(@PathParam("id") int id) {

        boolean status = studentDAO.deleteStudent(id);
        System.out.println("Student update Status :"+status);
        return studentDAO.getAllStudents();
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("id") String id, @QueryParam("name") String name)
    {
        return "Hello " + id + " " + name;
    }


    @GET
    @Path("/{userName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String printUserName(@PathParam("userName") String userId) {
        return userId;
    }

/**
 * urls:
 *localhost:3030/RESTFULService/StudentService/students
 *localhost:3030/RESTFULService/StudentService/addStudent
 *   {
 *     "id": 1,
 *     "name": "Vicky",
 *     "age": 22
 *   }
 *
 *localhost:3030/RESTFULService/StudentService/update
 * {
 *       "id": 5,
 *       "name": "vik",
 *       "age": 19
 *     }
 * localhost:3030/RESTFULService/StudentService/delete/5
 * localhost:3030/RESTFULService/StudentService/hello?id={1}&name={vicky}
 * localhost:3030/RESTFULService/StudentService/{}
 */
}
