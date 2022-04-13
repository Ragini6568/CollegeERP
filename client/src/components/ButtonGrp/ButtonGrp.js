import Button from "@mui/material/Button";
import ButtonGroup from "@mui/material/ButtonGroup";

const ButtonGrp = ({ setForm }) => {
  return (
    <ButtonGroup variant="contained">
      <Button
        onClick={() => {
          setForm((prevState) => ({ ...prevState, type: "Admin" }));
        }}
      >
        Admin
      </Button>
      <Button
        onClick={() => {
          setForm((prevState) => ({ ...prevState, type: "Student" }));
        }}
      >
        Student
      </Button>
      <Button
        onClick={() => {
          setForm((prevState) => ({ ...prevState, type: "Teacher" }));
        }}
      >
        Teacher
      </Button>
    </ButtonGroup>
  );
};

export default ButtonGrp;
