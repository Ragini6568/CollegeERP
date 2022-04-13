import { Paper, TextField, Button } from "@mui/material";
import { Fragment } from "react";
import useStyles from "../Add/styles";
import { useState } from "react";
import ButtonGrp from "../../ButtonGrp/ButtonGrp";
import axios from "axios";

const initialForm = {
  id: "",
  type: "Admin",
};
const Form = () => {
  const classes = useStyles();
  const [form, setForm] = useState(initialForm);

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
      url = `http://localhost:9090/college-erp/admin/delete/${form.id}`;
      newForm = {
        id: form.id,
      };
    } else if (form.type === "Student") {
      url = `http://localhost:9090/college-erp/admin/deletestudent/${form.id}`;
      newForm = {
        id: form.id,
      };
    } else if (form.type === "Teacher") {
      url = `http://localhost:9090/college-erp/admin/deleteteacher/${form.id}`;
      newForm = {
        id: form.id,
      };
    }

    try {
      const response = await axios.delete(url, newForm);
      alert(response.data);
      console.log(response);
    } catch (error) {
      alert(error);
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
