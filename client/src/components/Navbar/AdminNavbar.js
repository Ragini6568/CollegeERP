import { Link, useLocation } from "react-router-dom";
import { Button } from "@mui/material";
import useStyles from "./styles";

const AdminNavbar = () => {
  const classes = useStyles();
  const location = useLocation();
  const path = location.pathname;
  console.log(path);

  return (
    <div>
      <div className={path === `/admin/home` ? classes.active : classes.active}>
        <Button component={Link} to={`/admin/home`}>
          Home
        </Button>
      </div>
      <div className={path === `/admin/add` ? classes.active : classes.active}>
        <Button component={Link} to={`/admin/add`}>
          Add
        </Button>
      </div>
      {/* <Button
        className={path === `/admin/update/` ? classes.active : classes.button}
        component={Link}
        to={`/admin/update/`}
      >
        Update
      </Button> */}
      <div
        className={path === `/admin/delete` ? classes.active : classes.active}
      >
        <Button component={Link} to={`/admin/delete`}>
          Delete
        </Button>
      </div>
      <div className={path === `/admin/get` ? classes.active : classes.active}>
        <Button component={Link} to={`/admin/get`}>
          Get
        </Button>
      </div>
    </div>
  );
};

export default AdminNavbar;
