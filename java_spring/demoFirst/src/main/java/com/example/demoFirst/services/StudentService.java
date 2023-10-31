package com.example.demoFirst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demoFirst.models.Student;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Gérer le cas où l'étudiant n'est pas trouvé.
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null; // Gérer le cas où l'étudiant n'est pas trouvé.
    }

    public Student createStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    public String deleteStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return "Étudiant avec l'id " + id + " supprimé";
            }
        }
        return "Étudiant avec l'id " + id + " non trouvé";
    }

    public String updateStudent(int id, Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setFirstname(updatedStudent.getFirstname());
                student.setAge(updatedStudent.getAge());
                return "Étudiant avec l'id " + id + " mis à jour";
            }
        }
        return "Étudiant avec l'id " + id + " non trouvé";
    }
}
