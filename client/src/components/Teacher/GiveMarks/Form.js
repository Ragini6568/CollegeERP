import { Fragment, useState } from "react";
import axios from "axios";
import { Paper, TextField, Button } from "@mui/material";
import useStyles from "./styles";

const initialForm = {
  id: "",
  subjectid: "",
  studentid: "",
  marks: "",
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
    url = "http://localhost:9090/college-erp/teacher/givemarks";
    newForm = {
      id: form.id,
      subject: {
        id: form.subjectid,
      },
      student: {
        id: form.studentid,
      },
      marks: form.marks,
    };

    try {
      const response = await axios.post(url, newForm);
      alert(" Marks added successfully");
      console.log(response);
    } catch (error) {
      alert("Error occured\n");
    }
  };

  return (
    <Fragment>
      <Paper className={classes.form} elevation={2}>
        <form onSubmit={submitHandler}>
          <div className={classes.textfield}>
            <TextField
              label="ID"
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
              label="Student ID"
              name="studentid"
              type="text"
              value={form.studentid}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
          </div>
          <div className={classes.textfield}>
            <TextField
              label="Subject ID"
              name="subjectid"
              type="text"
              value={form.subjectid}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
          </div>
          <div className={classes.textfield}>
            <TextField
              label="Marks"
              name="marks"
              type="text"
              value={form.marks}
              onChange={inputChangeHandler}
              variant="outlined"
              fullWidth
            />
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
