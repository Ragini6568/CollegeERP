import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Add from "./components/Admin/Add/Add";
import Delete from "./components/Admin/Delete/Delete";
import Get from "./components/Admin/Get/Get";
import Home from "./components/Home/Home";
import Layout from "./components/Navbar/Layout";
import Home1 from "./components/Admin/Home/Home";
import Student from "./components/Student/Home/Home";
import Teacher from "./components/Teacher/Home/Home";
import Add1 from "./components/Teacher/GiveMarks/Add";
import Add2 from "./components/Teacher/GiveAttendance/Add";
import Add3 from "./components/Student/GiveMarks/Add";

const App = () => {
  return (
    <Router>
      <Layout>
        <Routes>
          <Route path="/admin/add" element={<Add />} />
          <Route path="/admin/delete" element={<Delete />} />
          <Route path="/admin/get" element={<Get />} />
          <Route path="/admin/home" element={<Home1 />} />
          <Route path="/student/home" element={<Student />} />
          <Route path="/teacher/home" element={<Teacher />} />
          <Route path="/teacher/givemarks" element={<Add1 />} />
          <Route path="/teacher/giveattendance" element={<Add2 />} />
          <Route path="/student/feedback" element={<Add3 />} />
          <Route path="/" element={<Home />} />
        </Routes>
      </Layout>
    </Router>
  );
};

export default App;
