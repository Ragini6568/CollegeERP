import { Fragment } from "react";
import { useLocation } from "react-router";
import Navbar from "./Navbar";

const Layout = (props) => {
  const location = useLocation();

  const homePage = location.pathname === "/";

  return (
    <Fragment>
      {!homePage && <Navbar />}
      {props.children}
    </Fragment>
  );
};

export default Layout;
