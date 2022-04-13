import { Link, useLocation } from "react-router-dom";
import { Button } from "@mui/material";
import useStyles from "./styles";

const TeacherNavbar = () => {
  const classes = useStyles();
  const location = useLocation();
  const path = location.pathname;
  console.log(path);

  return (
    <div>
      <div
        className={path === `/teacher/home` ? classes.active : classes.active}
      >
        <Button component={Link} to={`/teacher/home`}>
          Home
        </Button>
      </div>
      <div
        className={
          path === `/teacher/givemarks` ? classes.active : classes.active
        }
      >
        <Button component={Link} to={`/teacher/givemarks`}>
          Add Marks
        </Button>
      </div>
      <div
        className={
          path === `/teacher/giveattendance` ? classes.active : classes.active
        }
      >
        <Button component={Link} to={`/teacher/giveattendance`}>
          Add Attendance
        </Button>
      </div>
      {/* <div
        className={path === `/admin/delete` ? classes.active : classes.active}
      >
        <Button component={Link} to={`/admin/delete`}>
          Delete
        </Button>
      </div>
      <div className={path === `/admin/get` ? classes.active : classes.active}>
        <Button component={Link} to={`/admin/get`}>
          Get
        </Button> */}
      {/* </div> */}
    </div>
  );
};

export default TeacherNavbar;
