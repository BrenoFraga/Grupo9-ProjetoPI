import * as React from 'react';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import CloseIcon from '@mui/icons-material/Close';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';

import '../styles/findr-box-style.css'
import { Icon } from '@mui/material';
import Fade from '@mui/material/Fade';
import { useEffect } from "react";
import { useState } from "react";
import api from "../api";
import footerImage from '../imgs/efects2.png'
import { SettingsInputAntennaTwoTone } from '@mui/icons-material';


const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
}));


let position = 0


export default function FindrBox(props) {
  const [expanded, setExpanded] = React.useState(false);
  const [name, setName] = React.useState(props.name);
  const [idFreelancer, setIdFreelancer] = React.useState(props.idUserFreelancer);
  const [avaliableTime, setAvaliableTime] = React.useState(props.avaliableTime);
  const [image, setImage] = React.useState("");
  const [firstSkill, setFirstSkill] = React.useState("");
  const [secondSkill, setSecondSkill] = React.useState("");
  const [thirdSkill, setThirdSkill] = React.useState("");
  const [userParagraph, setUserParagraph] = React.useState("");
  const [userMatch, setUserMatch] = React.useState(false);

  const [userList, setUserList] = useState([]);
  const [userSkills, setUserSkills] = useState([]);
  const[nameList, setNameList] = useState([]);

  

  // const handleFavoriteClick = (event, message) => {
  //   position = position + 1
  //   // setName(event.target.value = items[position].name)
  //   // setImage(event.target.value = items[position].img)
  //   // setFirstSkill(event.target.value = items[position].firstSkill)
  //   // setSecondSkill(event.target.value = items[position].secondSkill)
  //   // setThirdSkill(event.target.value = items[position].thirdSkill)
  //   // setUserMatch(event.target.value = items[position].likedYou)
  //   // setUserParagraph(event.target.value = items[position].userParagraph)
    
  //   api.post("/freelancer/",{idFreelancer},"/1/true").then(res => {
  //     alert("Like enviado com sucesso!");
  //   }).catch(erro => {
  //     alert("Deu ruim!");
  //     console.log(erro);
  //   })
      
  //   if (userMatch) {
  //     alert("Its a Match!")
  //   }

    
  //   var element = document.getElementById("full-card");
  //     element.classList.remove("run-like-animation");
  //     void element.offsetWidth;
  //     element.classList.add("run-like-animation");

  // };

  const handleRejectClick = (event, message) => {
    // position = position + 1
    // setName(event.target.value = items[position].name)
    // setImage(event.target.value = items[position].img)
    // setFirstSkill(event.target.value = items[position].firstSkill)
    // setSecondSkill(event.target.value = items[position].secondSkill)
    // setThirdSkill(event.target.value = items[position].thirdSkill)
    // setUserParagraph(event.target.value = items[position].userParagraph)

    var element = document.getElementById("full-card");
      element.classList.remove("run-reject-animation");
      void element.offsetWidth;
      element.classList.add("run-reject-animation");

  };



  const handleExpandClick = () => {
    setExpanded(!expanded);
  };

  useEffect(() => {
    api.get("/specialty/freelancer/"+idFreelancer).then((res) => {
      setUserList(res.data);
    }).catch((err) => {
      console.log(err);
    })
  }, [])


  return (<>
  {localStorage.setItem('idFreelancer', idFreelancer)}
     <Card id="full-card" sx={{ maxWidth: 700, minWidth: 500 , borderRadius: 4 }}>
      <CardHeader class="header" sx={{ p: 0 }}
        avatar={<>
          <Avatar aria-label="recipe" class="avatar-user">
          </Avatar>
        </>
        }
        
        title= {props.title}        
        subheader="Profissão atual: Desenvolvedor Back-end na ALPE"
      />
     

      <CardContent id="teste-column">
      <CardMedia
          component="img"
          height="100"
          image={props.firstSkill}
          alt="Primeira habilidade"
          class="language-card"
          sx={{
            borderRadius: 85,
            width: 1/3
          }}
        />
        <Typography variant="h4" color="text.secondary" class="user-paragraph" id="main-ability">
         Principal Linguagem
        </Typography>
        <CardMedia
          component="img"
          height="100"
          image={props.secondSkill}
          alt="Segunda habilidade"
          class="language-card"
          sx={{
            borderRadius: 85,
            width: 1/3
          }}
        />
         <Typography variant="h4" color="text.secondary" class="user-paragraph"  id="secondary-ability">
         Média proficiência
        </Typography>
        
        <CardMedia
          component="img"
          height="100"
          image={props.thirdSkill}
          alt="Terceira habilidade"
          class="language-card"
          sx={{
            borderRadius: 85,
            width: 1/3
          }}
        />
        
        <Typography variant="h3" color="text.secondary" class="user-paragraph" id="tertiary-ability">
         "Sei me virar..."
        </Typography>
      </CardContent>

      <Typography variant="h4" id="final-availability-title">
       Disponibilidade (em horas/semana):
      </Typography>

      <Typography variant="h4" id="final-availability-title"  onChange={(e) => setAvaliableTime(e.target.value)}>
      {props.avaliableTime}
      </Typography>
      
     
    
      
      {/* <CardActions id="card-actions">
        <IconButton aria-label="Recusar" onClick={(event) => handleRejectClick(event, 'hello')}>
          <CloseIcon id="not-interested-icon" />
        </IconButton>
        <IconButton aria-label="Favoritar" onClick={(event) => handleFavoriteClick(event, 'hello')}>
          <FavoriteIcon id="favorite-button-icon" />
        </IconButton>

      </CardActions> */}
      
      <Card id="footer">
        <CardMedia id="footer-image"
          component="img"
          height="100"
         image={footerImage}
         sx={{
          padding: 0
        }}>
        </CardMedia>
      </Card>
    </Card> 
  </>
  );
}