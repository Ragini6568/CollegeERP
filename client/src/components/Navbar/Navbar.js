import { Fragment } from "react";
import { AppBar, Grid, Toolbar, Typography } from "@mui/material";
import AdminNavbar from "./AdminNavbar";
import StudentNavbar from "./StudentNavbar";
import TeacherNavbar from "./TeacherNavbar";
import useStyles from "./styles";
import { useLocation } from "react-router-dom";

const Navbar = () => {
  const classes = useStyles();
  const location = useLocation();
  const type = location.pathname.split("/")[1];

  return (
    <Fragment>
      <AppBar
        style={{ backgroundColor: "#6C63FF", color: "white" }}
        position="static"
        elevation={0}
      >
        <Toolbar className={classes.extraMargin}>
          <Typography className={classes.title} variant="h6">
            College ERP
          </Typography>
          <Grid>{type === "admin" && <AdminNavbar />}</Grid>
          <Grid>{type === "teacher" && <TeacherNavbar />}</Grid>
          <Grid>{type === "student" && <StudentNavbar />}</Grid>
        </Toolbar>
      </AppBar>
    </Fragment>
  );
};

export default Navbar;
