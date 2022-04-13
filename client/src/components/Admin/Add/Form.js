import { Fragment, useState } from "react";
import axios from "axios";
import ButtonGrp from "../../ButtonGrp/ButtonGrp";
import { Paper, TextField, Button } from "@mui/material";
import useStyles from "./styles";

const initialForm = {
  id: "",
  firstName: "",
  lastName: "",
  aadharCard: "",
  email: "",
  password: "",
  mobileNumber: "",
  subjectid: "",
  type: "Admin",
};

const Form = () => {
  const [form, setForm] = useState(initialForm);
  const classes = useStyles();

  const inputChangeHandler = (event) => {
    setForm((prevState) => ({
      ...prevState,
      [event.target.name]: event.target.value,
    }));
  };

  const submitHandler = async (event) => {
    event.preventDefault();

    let url = "";
    let newForm = "";
    if (form.type === "Admin") {
      url = "http://localhost:9090/college-erp/admin/signup";
      newForm = {
        id: form.id,
        firstName: form.firstName,
        lastName: form.lastName,
        aadharCard: form.aadharCard,
        email: form.email,
        password: form.password,
        mobileNumber: form.mobileNumber,
      };
    } else if (form.type === "Student") {
      url = "http://localhost:9090/college-erp/admin/studentsignup";
      newForm = {
        id: form.id,
        firstName: form.firstName,
        lastName: form.lastName,
        aadharCard: form.aadharCard,
        email: form.email,
        password: form.password,
        mobileNumber: form.mobileNumber,
      };
    } else if (form.type === "Teacher") {
      url = "http://localhost:9090/college-erp/admin/teachersignup";
      newForm = {
        id: form.id,
        firstName: form.firstName,
        lastName: form.lastName,
        aadharCard: form.aadharCard,
        email: form.email,
        password: form.password,
        mobileNumber: form.mobileNumber,
        subject: {
          id: form.subjectid,
        },
      };
    }

    try {
      const response = await axios.post(url, newForm);
      alert(
        "Id: " +
          response.data.id +
          "\n" +
          "FirstName: " +
          response.data.firstName +
          "\n" +
          "LastName: " +
          response.data.lastName +
          "\n" +
          "AadharCard: " +
          response.data.aadharCard +
          "\n" +
          "Mobile Number: " +
          response.data.mobileNumber +
          "\n" +
          "Email: " +
          response.data.email +
          "\n" +
          "Added successfully"
      );
      console.log(response);
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
          <div className={classes.textfield}>
            <TextField
              label={`${form.type} ID`}
              name="id"
              type="text"
              value={form.id}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
          </div>
          <div className={classes.textfield}>
            <TextField
              label="First Name"
              name="firstName"
              type="text"
              value={form.firstName}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
          </div>
          <div className={classes.textfield}>
            <TextField
              label="Last Name"
              name="lastName"
              type="text"
              value={form.lastName}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
          </div>
          <div className={classes.textfield}>
            <TextField
              label="Aadhar Card"
              name="aadharCard"
              type="text"
              value={form.aadharCard}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
          </div>
          <div className={classes.textfield}>
            <TextField
              label="Email"
              name="email"
              type="email"
              value={form.email}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
          </div>
          <div className={classes.textfield}>
            <TextField
              label="Password"
              name="password"
              type="password"
              value={form.password}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
          </div>
          <div className={classes.textfield}>
            <TextField
              label="Mobile Number"
              name="mobileNumber"
              type="text"
              value={form.mobileNumber}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
          </div>
          <div className={classes.textfield}>
            {form.type === "Teacher" && (
              <TextField
                label="Subject ID"
                name="subjectid"
                type="text"
                value={form.subjectid}
                onChange={inputChangeHandler}
                variant="outlined"
                fullWidth
              />
            )}
          </div>
          <div className={classes.button}>
            <Button type="submit" variant="contained">
              Submit
            </Button>
          </div>
        </form>
      </Paper>
    </Fragment>
  );
};

export default Form;
