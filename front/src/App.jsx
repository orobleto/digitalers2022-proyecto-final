import React, { Component } from "react"
import { BrowserRouter, NavLink, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import NotFound from "./components/NotFound";
import './resources/css/menu.css';

export default class App extends Component {

    constructor(props) {
        super(props);
    }
    
    printUUID=()=>{
        console.log(localStorage);
    }

    render() {
        return (
            <BrowserRouter>

                <nav class="menu">
                    <NavLink className="enlace" to="/" >Principal</NavLink>

                    <NavLink className="enlace" to="/publications" >Publicaciones</NavLink>

                    <NavLink className="enlace" to="/comments" >Comentarios</NavLink>
                </nav>


                <Routes>
                    <Route path="/" element={<Login />} />
                    <Route path="/publications" element={<div>Publicaciones</div>} />
                    <Route path="/comments" element={<button onClick={this.printUUID}>Mostrar UUID</button>} />
                    <Route path="*" element={<NotFound />} />
                    <Route />
                </Routes>

            </BrowserRouter>

        );
    }
}