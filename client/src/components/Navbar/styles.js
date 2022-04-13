import { makeStyles } from "@mui/styles";

const useStyles = makeStyles({
  desktop: {
    display: "flex",
    // [theme.breakpoints.up("md")]: {
    //   display: "none",
    // },
  },

  mobile: {
    display: "none",
    // [theme.breakpoints.up("md")]: {
    //   display: "flex",
    // },
  },

  title: {
    flexGrow: 1,
    color: "white",
  },

  extraMargin: {
    margin: "5px 50px",
  },

  button: {
    display: "inline",
    marginRight: "10px",
    padding: "7px",
    color: "white",
    "&:hover": {
      backgroundColor: "white",
      color: "#6C63FF",
    },
  },

  active: {
    display: "inline",
    marginRight: "10px",
    padding: "7px",
    color: "#6C63FF",
    backgroundColor: "white",
    "&:hover": {
      backgroundColor: "#6C63FF",
      color: "white",
    },
  },
});

export default useStyles;
