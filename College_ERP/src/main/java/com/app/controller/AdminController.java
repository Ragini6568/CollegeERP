package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.pojos.Attendance;
import com.app.pojos.Batch;
import com.app.pojos.Course;
import com.app.pojos.Mark;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Teacher;
import com.app.service.IAdminService;
import com.app.service.IBatchService;
import com.app.service.ICourseService;
import com.app.service.IMarkService;
import com.app.service.IStudentService;
import com.app.service.ISubjectService;
import com.app.service.ITeacherService;


@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/college-erp")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	@Autowired
	private IBatchService batchService;
	@Autowired
	private ICourseService courseService;
	@Autowired
	private ISubjectService subjectService;
	@Autowired
	private IStudentService studentService;
	@Autowired
	private ITeacherService teacherService;
	@Autowired
	private IMarkService markService;
	
	public AdminController() {
		System.out.println("in admin controller");
	}
	
	//methods: insert update get getall delete 
	
	//method to add admin details 
	//admin details will be in request body
	@PostMapping("/admin/signup")
	public Admin addAdminDetails(@RequestBody Admin admin) {
		
		return adminService.addAdminDetails(admin);
	}
	
	//method to get all admin details
	@GetMapping("/admin")
	public List<Admin> getAllAdminDetails(){
		System.out.println("in get all admins");
		return adminService.getAllAdmins();
	}
	
	//getting admin details 
	@GetMapping("/admin/getadmin/{aid}")
	public Admin getAdminDetails(@PathVariable String aid) {
		System.out.println("in admin get method in controller");
		return adminService.getAdmin(aid);	
	}
	
	//delete admin
	@DeleteMapping("/admin/delete/{id}")
	public String deleteAdmin(@PathVariable String id)
	{
		System.out.println("in delete admin"+id);
		return adminService.deleteAdmin(id);
	}
	
	//update admin
	@PutMapping("/admin/updateadmin")
	public Admin updateAdmin(@RequestBody Admin admin)
	{
		System.out.println("in update admin");
		return adminService.updateAdmin(admin);
	}
	
	//add batch
	@PostMapping("/admin/addBatch")
	public Batch addBatch(@RequestBody Batch batch)
	{
		System.out.println("in add batch admin controller");
		return batchService.addBatch(batch);
	}
	
	//delete batch
	@DeleteMapping("/admin/deleteBatch/{id}")
	public String deleteBatch(@PathVariable int id)
	{
		System.out.println("in delete batch admin controller");
		return batchService.deleteBatch(id);
	}
	
	@PostMapping("/admin/addCourse")
	public Course addCourse(@RequestBody Course course)
	{
		System.out.println("in add course admin controller");
		return courseService.addCourse(course);
	}
	
	@DeleteMapping("/admin/deleteCourse/{id}")
	public String deleteCourse(@PathVariable String id)
	{
		System.out.println("in delete course admin controller");
		return courseService.deleteCourse(id);
	}
	
	@PostMapping("/admin/addSubject")
	public Subject addSubject(@RequestBody Subject subject)
	{
		System.out.println("in add subject admin controller");
		return subjectService.addSubject(subject);
	}
	
	@DeleteMapping("/admin/deleteSubject/{id}")
	public String deleteSubject(@PathVariable String id)
	{
		System.out.println("in delete subject admin controller");
		return subjectService.deleteSubject(id);
	}
	
	@GetMapping("/admin/getallsubjects")
	public List<Subject> getAllSubjectDetails(){
		System.out.println("in get all subjects");
		return subjectService.getAllSubjects();
	}
	
	
	@GetMapping("/admin/getallstudents")
	public List<Student> getAllStudentDetails(){
		System.out.println("in get all students");
		return studentService.getAllStudents();
	}
	
	//getting student details 
			@GetMapping("/admin/getstudent/{sid}")
			public Student getStudentDetails(@PathVariable String sid) {
				System.out.println("in student get method in controller");
				return studentService.getStudent(sid);
			}
	
	//delete admin
	@DeleteMapping("/admin/deletestudent/{sid}")
	public String deleteStudent(@PathVariable String sid)
	{
		System.out.println("in delete student"+sid);
		return studentService.deleteStudent(sid);
	}
	
	//update admin
	@PutMapping("/admin/updatestudent")
	public Student updateStudent(@RequestBody Student student)
	{
		System.out.println("in update student");
		return studentService.updateStudent(student);
	}
	
	@PostMapping("/admin/studentsignup")
	public Student addStudentDetails(@RequestBody  Student student) {
		
		return studentService.addStudentDetails(student);
	}
	
	@PostMapping("/admin/teachersignup")
	public Teacher addTeacherDetails(@RequestBody  Teacher teacher) {
		
		//System.out.println(teacher.getSubject().getId());
		return teacherService.addTeacherDetails(teacher);
	}
	
	@DeleteMapping("/admin/deleteteacher/{sid}")
	public String deleteTeacher(@PathVariable String sid)
	{
		System.out.println("in delete teacher "+sid);
		return teacherService.deleteTeacher(sid);
	}
	
	//getting student details 
	@GetMapping("/admin/getteacher/{tid}")
	public Teacher getTeacherDetails(@PathVariable String tid) {
		System.out.println("in teacher get method in controller");
		return teacherService.getTeacher(tid);
	}
	
	//update admin
		@PutMapping("/admin/updateteacher")
		public Teacher updateTeacher(@RequestBody Teacher teacher)
		{
			System.out.println("in update teacher");
			return teacherService.addTeacherDetails(teacher);
		}
		
		@PostMapping("/admin/login")
		public Admin loginAdmin(@RequestBody Admin admin1) {
			Admin admin=adminService.getAdmin(admin1.getId());
			if(admin!=null) {
			System.out.println("Admin authentication successful");
			if((admin.getPassword().compareTo(admin1.getPassword()))==0)
			{
				System.out.println("Admin login with ID: "+admin1.getId()+" successful");
				return admin;
			}
			}
			System.out.println("Admin login with ID: "+admin1.getId()+" failed");
			return null;
			
		}
		
		@PostMapping("/student/login")
		public Student loginStudent(@RequestBody Student student1) {
			Student student=studentService.getStudent(student1.getId());
			if(student!=null) {
			System.out.println("Student authentication successful");
			if((student.getPassword().compareTo(student1.getPassword()))==0)
			{
				System.out.println("Student login with ID: "+student1.getId()+" successful");
				return student;
			}
			}
			System.out.println("Student login with ID: "+student1.getId()+" failed");
			return null;
			
		}
		
		@PostMapping("/teacher/login")
		public Teacher loginTeacher(@RequestBody Teacher teacher1) {
			//System.out.println(teacher1.getSubject().getId());
			Teacher teacher=teacherService.getTeacher(teacher1.getId());
			if(teacher!=null) {
			System.out.println("Teacher authentication successful");
			if((teacher.getPassword().compareTo(teacher1.getPassword()))==0)
			{
				System.out.println("Teacher login with ID: "+teacher1.getId()+" successful");
				return teacher;
			}
			}
			System.out.println("Teacher login with ID: "+teacher1.getId()+" failed");
			return null;
			
		}
		
		@PostMapping("/teacher/givemarks")
		public Mark addMarkDetails(@RequestBody Mark mark) {
			//System.out.println(teacher1.getSubject().getId());
			System.out.println("in give marks admin controller");
			return markService.addMarkDetails(mark);
			
		}
		
		@PostMapping("/teacher/giveattendance")
		public Attendance addAttendance(@RequestBody Attendance attendance) {
			//System.out.println(teacher1.getSubject().getId());
			System.out.println("in give attendance admin controller");
			return markService.addAttendance(attendance);
			
		}
}
