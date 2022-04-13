import { Paper, Typography, Button } from "@mui/material";
import { useNavigate } from "react-router-dom";
import useStyles from "./styles";

const Home = () => {
  const classes = useStyles();
  const navigate = useNavigate();
  const admin = JSON.parse(localStorage.getItem("profile"));

  return (
    <Paper className={classes.form} elevation={2}>
      <Typography gutterBottom>
        Name: {admin.firstName} {admin.lastName}
      </Typography>
      <Typography gutterBottom>Email: {admin.email}</Typography>
      <Typography gutterBottom>AadharCard: {admin.aadharCard}</Typography>
      <Typography gutterBottom>Mobile Number: {admin.mobileNumber}</Typography>

      <div className={classes.button}>
        <Button
          onClick={() => {
            localStorage.removeItem("profile");
            navigate("/");
          }}
        >
          Logout
        </Button>
      </div>
    </Paper>
  );
};

export default Home;
