import { Fragment, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import ButtonGrp from "../ButtonGrp/ButtonGrp";
import { Paper, TextField, Button } from "@mui/material";
import useStyles from "./styles";

const initialForm = {
  id: "",
  password: "",
  type: "Admin",
};

const Form = () => {
  const [form, setForm] = useState(initialForm);
  const classes = useStyles();
  const navigate = useNavigate();

  const inputChangeHandler = (event) => {
    setForm((prevState) => ({
      ...prevState,
      [event.target.name]: event.target.value,
    }));
  };

  const submitHandler = async (event) => {
    event.preventDefault();

    let url = "";
    let newForm = form;
    let navigateUrl = "";

    if (form.type === "Admin") {
      url = "http://localhost:9090/college-erp/admin/login";
      navigateUrl = "admin/home";
    } else if (form.type === "Student") {
      url = "http://localhost:9090/college-erp/student/login";
      navigateUrl = "student/home";
    } else if (form.type === "Teacher") {
      url = "http://localhost:9090/college-erp/teacher/login";
      navigateUrl = "teacher/home";
    }

    try {
      const response = await axios.post(url, newForm);
      console.log(response);

      localStorage.setItem("profile", JSON.stringify(response.data));
      if (response.data !== "") {
        navigate(navigateUrl);
      } else {
        alert("Login failed!!!!!");
        navigate("/");
      }
    } catch (error) {
      alert("Error occured\n");
    }
  };

  return (
    <Fragment>
      <div className={classes.buttonGrp}>
        <ButtonGrp setForm={setForm} />
      </div>

      <Paper className={classes.form} elevation={2}>
        <form onSubmit={submitHandler}>
          <TextField
            label={`${form.type} ID`}
            name="id"
            type="text"
            value={form.id}
            onChange={inputChangeHandler}
            variant="outlined"
            fullWidth
          />

          <TextField
            label="Password"
            name="password"
            type="password"
            value={form.password}
            onChange={inputChangeHandler}
            variant="outlined"
            fullWidth
          />

          <div className={classes.button}>
            <Button type="submit" variant="contained">
              Login
            </Button>
          </div>
        </form>
      </Paper>
    </Fragment>
  );
};

export default Form;
