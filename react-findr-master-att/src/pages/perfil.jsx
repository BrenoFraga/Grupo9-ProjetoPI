import FindrMenu from "../components/findr-menu";
import * as React from 'react';
import CardMatch from "../components/component-tela-perfil/match/card-match";
import "../styles/findr-perfil-free-style.css";
import { useEffect } from "react";
import { useState } from "react";
import api from "../api";
import CardPerfil from "../components/component-tela-perfil/card-perfil";

function Perfil() {

    const [matchs, setMatchs] = useState([]);
    const [infoUser, setInfoUser] = useState([]);

    useEffect(() => {

        api.get(`/match/projetos/${sessionStorage.idUsuario}`).then((res) => {
            console.log(res.data)
            if (res == null) {
                setMatchs(res.data.null);
            } else {
                setMatchs(res.data);
            }
            console.log(res.data)
        }).catch((err) => {
            console.log(err);
        })

    }, [])

    useEffect(() => {

        api.get(`/freelancer/perfil/${sessionStorage.email}`).then((res) => {
            setInfoUser(res.data);
            console.log(res.data)
        }).catch((err) => {
            console.log(err);
        })

    }, [])

    return (
        <div class="screen-perfil">
            <FindrMenu />

            <div class="screen2">
                {
                    <CardPerfil
                        name={infoUser.name}
                        state={infoUser.state}
                        city={infoUser.city}
                        technologyUsed={infoUser.technologyUsed}
                    />
                }

                <div class="screen3">
                    <div class="certificacoes">
                        <div class="certificacoes-titulo">
                            <h1>Certificações</h1>

                        </div>
                        <div class="certificado-info">
                            <img src="https://apexensino.com.br/wp-content/uploads/2020/05/26-java-logo.jpg" alt="" />
                            <div class="certificado-info-mais">
                                <h3>Sobre o que é o certificado</h3>
                                <p>Plataforma</p>
                                <p>Emissão</p>
                            </div>
                        </div>
                        <div class="certificado-info">
                            <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAolBMVEX///8dq/z9iSUApfzo9P/9gAD/8OkArP//hwC1pJ7+x56Y1f0Ap/y3pZ3+x6D9ggb/iBv/iBH58+8An/wApf9Pp934hRj9eAD+wJNKrOf4jjI9q+wpq/X0kDzpk1DelF3TlWbFlna3mImvmpOhnKGPnq98oLxyocNio8/4iiYtqfDpjD3jjUbNkmq5loKQnKffjlGFnrRcpNWmmZebm6PVtZ3x+J/xAAADwklEQVR4nO3diVIUMRjE8Yx7fIsXAqKi64kK3vf7v5oMM7jHXEnvzKSz9v8J+FU6LCmowjmllFJKKaWUUkoppZRSSimllFJKKaWUUkoppZRSSqlRmoIdz8FGB55MkB6ePppBPX4yunCSAdnZ0we3kGa3xwZiQnsGAg/HB0JCWz4HgffHByJCW75IZqKQ0LKXRwkBkTN8hQFj3EFIaK9BYIw7iAjtzQICRppouNDOUwMGCu0tBox1B4OF9g4ExrqDoUJ7n9xEw4R2kd5Eg4R2mdCPaojQTo8gYdyJBgjt7EOaQF8h+l6KfAf9hfbxEwaMfAe9hZZ9TnSizk+IvpcogH5n+AUCEtzBPA8h+F7iOEEfoX2FfpRhAXYLwfcSyURdtxB8LzF8TJR1CO1b2hN1XULwvcQEbBeC7yWeO5jXJgTfS0R3MK9FCL6XqCbq2oR2thfAZiH4XuK6g3lNQvC9RHeCjULL9gXYILTs+35M1DUIDfv9EtnHRFm9EHoQMk7U1QuxByEpsE6I/QKN8g7mVYX2CwJS3sG8ihB7L7FO1FWF9mOvJuoqQuxByDtRty20i336Llq0IbSfyHOCG7ghtNMFAGS+g3lrQuwPDqnvYN5KiL2XyCfq1oS23E/gP6EtkV+gsd/BvFKIvZcSOMGVEHkvJQEshdB7KYWJulIIvZfoPybKciH0Xkpjou5aaL8B4OJP7K/ct+kE+oPDxcHdO7G/dM+mE+S9tDiwLBXi9BL4Lrq4Z1ffnxIhHh+iwCybJEGcz8KBB1b+LJvEKYYLV8A0iMHCm4kmQwwVbgJTuIuBwvWJJnKKYcLtE0yBGCSsA9IPNURYnWgKpxggbAKSE/2F9RPlJ3oL24DUd9FX2DxR9lP0FHYBiYl+wvaJchO9hD5A2rvoI+yeKPMpegj9TpCW2C30B3IOtVPoO1HaU+wShgEZiR3CkImSEtuF4UC+u9gqDJ0o5Sm2CTEgG7FFiEy0iGqozUIcyEVsFKITLSIaapNwlxPkIjYIdwUSDbVeuNtEuU6xVtgHkIZYJ9x9okzEGmFfQJK7WBX2M9EihlOsCPs7QRLitrBfIMNQt4R9TpSEuCnsHxh/qBvCvidKQVwXDgOMPdQ14RATLYp6iivhcMC4xH/CoSYanXgjHBYY8y6WwiEnWhTtFAvh0CcYk3gtHAMYbai5cPiJFsU5xSvhWMBIxPlsnInGI85nIwKj3MX5OfT/LeBOxiei/6MEbnShUkoppZRSSimllFJKKaWUUkoppZRSSimllFJKKaX+0/4CzV5cM45jZQUAAAAASUVORK5CYII=" alt="" />
                            <div class="certificado-info-mais">
                                <h3>Sobre o que é o certificado</h3>
                                <p>Plataforma</p>
                                <p>Emissão</p>
                            </div>
                        </div>
                        <div class="certificado-info">
                            <img src="data:image/jpeg;base64,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" alt="" />
                            <div class="certificado-info-mais">
                                <h3>Sobre o que é o certificado</h3>
                                <p>Plataforma</p>
                                <p>Emissão</p>
                            </div>
                        </div>
                    </div>
                    <div className="matchs">
                        <h1>Matchs</h1>
                        <div className="container">
                            <div className="grid-container">
                                {matchs.map((item) => <CardMatch name={item.name} nameProject={item.nameProject} />)}
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    );
}

export default Perfil;