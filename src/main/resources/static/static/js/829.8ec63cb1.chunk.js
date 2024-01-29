"use strict";(self.webpackChunkteam1_project=self.webpackChunkteam1_project||[]).push([[829],{460:(n,e,i)=>{i.d(e,{Z:()=>o});i(2791);var s=i(7394),t=i(184);const o=n=>{const{bttext:e}=n;return(0,t.jsx)(s.L,{children:(0,t.jsx)("span",{children:e})})}},7394:(n,e,i)=>{i.d(e,{L:()=>l});var s,t=i(168),o=i(225),a=i(8096);const l=o.Z.button(s||(s=(0,t.Z)(["\n  position: relative;\n  display: flex;\n  flex-direction: column;\n  justify-content: center;\n  align-items: center;\n  padding: 10px 20px;\n  gap: 10px;\n  background: #fff;\n  border: 2px solid #066e52;\n  border-radius: 10px;\n  cursor: pointer;\n  span {\n    font-family: DAEAM_LEE_TAE_JOON;\n    font-size: 19px;\n    text-align: center;\n    font-style: normal;\n    font-weight: 400;\n    color: ",";\n  }\n"])),a.H.primary)},1764:(n,e,i)=>{i.d(e,{Z:()=>o});i(2791);var s=i(460),t=i(184);const o=n=>{let{title:e,content:i,callFn:o}=n;return(0,t.jsx)("div",{style:{position:"fixed",display:"flex",alignItems:"center",justifyContent:"center",left:0,top:0,width:"100%",height:"100%",background:"rgba(0,0,0,0.7)",zIndex:999},children:(0,t.jsxs)("div",{style:{background:"#fff",textAlign:"center",display:"flex",flexDirection:"column",gap:"20px",alignItems:"center",padding:"20px",width:"300px",borderRadius:"10px",fontFamily:"DAEAM_LEE_TAE_JOON",fontSize:"19px"},children:[(0,t.jsx)("div",{style:{paddingBottom:"5px",borderBottom:"1px dashed #8f8f8f"},children:e}),(0,t.jsx)("div",{style:{paddingBottom:"5px",borderBottom:"1px dashed #8f8f8f"},children:i}),(0,t.jsx)("div",{onClick:o,children:(0,t.jsx)(s.Z,{bttext:"\ud655\uc778"})})]})})}},2734:(n,e,i)=>{i.d(e,{Z:()=>r});var s=i(2791),t=i(7689),o=i(1087),a=i(2132),l=i(5913);const r=()=>{const n=(0,t.s0)(),[e,i]=(0,o.lr)(),{isModal:r,openModal:d,closeModal:c,moveToLogin:p}=(0,l.Z)(),x=e.get("page")?parseInt(e.get("page")):1,g=e.get("search")||"",h=e.get("category")?parseInt(e.get("category")):0,m=(0,o.fW)({page:x,search:g,category:h}).toString(),[j,v]=(0,s.useState)(!1);return{page:x,search:g,category:h,MoveToList:e=>{let i="";if(e){const n=(0,a.q)(e.category,h);i=(0,o.fW)({category:n}).toString()}else i=m;n({pathname:"../list",search:i})},moveToRead:e=>{n({pathname:"../detail/".concat(e),search:m})},moveToSearch:e=>{let i="";if(e){const n=(0,a.q)(e.search,g);i=(0,o.fW)({search:n}).toString(),console.log("queryStr:",i),v(!j)}else i=m;n({pathname:"../list",search:i})},refresh:j,isModal:r,openModal:d,closeModal:c,moveToLogin:p,moveToReser:e=>{n({pathname:"../reservation/".concat(e),search:m})},MoveToPage:e=>{let i="";if(e){const n=(0,a.q)(e.page,x);i=(0,o.fW)({page:n}).toString()}else i=m;n({pathname:"../list",search:i})},moveToReview:(e,i)=>{console.log(i),n({pathname:"../../meat/review/".concat(e),search:"name=".concat(i,"&").concat(m)})}}}},5428:(n,e,i)=>{i.d(e,{Z:()=>a});var s=i(4420),t=i(7689),o=i(9176);const a=()=>{const n=(0,t.s0)(),e=(0,s.I0)(),i=(0,s.v9)((n=>n.authSlice));return{authState:i,isLogin:1==i.result,doLogin:async n=>{let{authParam:i,successFn:s,failFn:t,errorFn:a}=n;return(await e((0,o.ft)({authParam:i,successFn:s,failFn:t,errorFn:a}))).payload},doLogout:()=>{e((0,o.kS)())},moveToPath:e=>{n({pathname:e},{replace:!0})},moveToLogin:()=>{n("/login")},loginComplete:()=>{n(-1)}}}},5913:(n,e,i)=>{i.d(e,{Z:()=>o});var s=i(2791),t=i(7689);const o=function(){const[n,e]=(0,s.useState)({isOpen:!1,title:"",content:"",callFn:null}),i=(0,t.s0)();return{isModal:n,openModal:(n,i,s)=>{e({isOpen:!0,title:n,content:i,callFn:s})},closeModal:()=>{e((n=>({...n,isOpen:!1})))},moveToLogin:()=>{e((n=>({...n,isOpen:!1}))),i("/login")}}}},4691:(n,e,i)=>{i.d(e,{Z:()=>S});i(2791);var s,t,o,a,l,r,d=i(4420),c=i(1087),p=i(5428),x=i(168),g=i(225),h=i(8096);const m=g.Z.div(s||(s=(0,x.Z)(["\n  position: relative;\n  img {\n    width: 150px;\n  }\n  @media (max-width: 670px) {\n    img {\n      display: none;\n    }\n  }\n"]))),j=g.Z.div(t||(t=(0,x.Z)(["\n  position: relative;\n  display: flex;\n  justify-content: flex-end;\n  gap: 2vw;\n  font-size: ",";\n\n  color: ",";\n  a {\n    text-decoration: none;\n    &:visited {\n      color: inherit;\n    }\n  }\n"])),h.B.default,h.H.g700),v=g.Z.div(o||(o=(0,x.Z)(['\n  position: relative;\n  margin-top: 2rem;\n  display: flex;\n  flex-wrap: wrap;\n  justify-content: flex-end;\n  gap: 4vw;\n  font-family: "DAEAM_LEE_TAE_JOON";\n  font-size: ',";\n  color: ",";\n  a {\n    text-decoration: none;\n    &:visited {\n      color: inherit;\n    }\n  }\n"])),h.B.strong,h.H.g700),u=g.Z.div(a||(a=(0,x.Z)(["\n  position: relative;\n  display: block;\n"]))),f=g.Z.div(l||(l=(0,x.Z)(["\n  position: relative;\n  display: flex;\n  flex-wrap: wrap;\n  justify-content: space-between;\n  margin: 0 auto;\n  padding: 2.1rem 2%;\n  border-bottom: 1px solid ",";\n  align-items: center;\n"])),h.H.g700),b=g.Z.div(r||(r=(0,x.Z)(["\n  span {\n    white-space: nowrap;\n    /* width: 200px; */\n  }\n  p {\n    display: inline;\n    color: red;\n  }\n"])));var y=i(2734),w=i(1764),Z=i(184);const T=()=>{const n=(0,d.v9)((n=>n.authSlice)),{isLogin:e,moveToPath:i,doLogout:s}=((0,d.I0)(),(0,p.Z)()),{isModal:t,openModal:o,closeModal:a,moveToLogin:l}=(0,y.Z)();return console.log(n),console.log(n.nickname),(0,Z.jsxs)(f,{children:[t.isOpen&&(0,Z.jsx)(w.Z,{title:t.title,content:t.content,callFn:t.callFn}),(0,Z.jsx)(m,{children:(0,Z.jsx)(c.rU,{to:"/main",children:(0,Z.jsx)("img",{src:"/assets/images/logo_1.svg",alt:"logo"})})}),(0,Z.jsxs)(u,{children:[e?(0,Z.jsxs)(j,{children:[(0,Z.jsx)(b,{children:(0,Z.jsxs)("span",{children:[(0,Z.jsx)("p",{children:n.nickname})," \ub2d8, \uace0\uae30\ub85c \ubc29\ubb38\uc744 \ud658\uc601\ud569\ub2c8\ub2e4."]})}),(0,Z.jsx)("div",{onClick:()=>{o("\ub85c\uadf8\uc544\uc6c3","\ub85c\uadf8\uc544\uc6c3\uc774 \uc644\ub8cc\ub418\uc5c8\uc2b5\ub2c8\ub2e4.",(()=>{a(),s(),i("/")}))},style:{cursor:"pointer"},children:"\ub85c\uadf8\uc544\uc6c3"})]}):(0,Z.jsxs)(j,{children:[(0,Z.jsx)(c.rU,{to:"/login",children:"\ub85c\uadf8\uc778"}),(0,Z.jsx)(c.rU,{to:"/join",children:"\ud68c\uc6d0\uac00\uc785"})]}),(0,Z.jsxs)(v,{children:[(0,Z.jsx)(c.rU,{to:"/meat",children:"\uace0\uae43\uc9d1\ucc3e\uae30"}),(0,Z.jsx)(c.rU,{to:"/butcher",children:"\uc815\uc721\uc810\ucc3e\uae30"}),(0,Z.jsx)(c.rU,{to:"/sale",children:"\ub9c8\uac10\uc138\uc77c"}),(0,Z.jsx)(c.rU,{to:"/community",children:"\uace0\uae30\uc7a1\ub2f4"}),e?(0,Z.jsx)(c.rU,{to:"/my",children:"\ub9c8\uc774\ud398\uc774\uc9c0"}):null]})]})]})};var N,B,A;const C=g.Z.div(N||(N=(0,x.Z)(["\n  position: relative;\n  padding: 2.1rem 18vw;\n  background: ",";\n  color: ",";\n  ul {\n    display: flex;\n    flex-wrap: wrap;\n    gap: 1vw;\n    justify-content: space-between;\n    align-items: center;\n    font-size: 1.4rem;\n    font-weight: ",";\n  }\n  @media (max-width: 1680px) {\n    padding: 2.1rem 5vw;\n  }\n"])),(n=>n.background),(n=>n.color),(n=>n.fontWeight)),E=g.Z.div(B||(B=(0,x.Z)(["\n  position: relative;\n  margin-top: ",";\n  margin-bottom: 0.5rem;\n  margin-left: 18vw;\n  margin-right: 18vw;\n  padding: 0;\n  color: ",";\n  ul {\n    display: flex;\n    flex-wrap: wrap;\n    gap: 1vw;\n    justify-content: flex-start;\n    font-weight: ",";\n    font-size: 1.4rem;\n    line-height: 1.75rem;\n  }\n  @media (max-width: 1680px) {\n    margin-left: 5vw;\n    margin-right: 5vw;\n  }\n"])),(n=>n.marginTop),(n=>n.color),(n=>n.fontWeight)),k=g.Z.div(A||(A=(0,x.Z)(["\n  position: relative;\n  margin: 0 18vw;\n  border-top: 1px solid ",";\n  @media (max-width: 1680px) {\n    margin: 0 5vw;\n  }\n"])),h.H.g600),L=()=>(0,Z.jsxs)("footer",{children:[(0,Z.jsx)(C,{background:h.H.g700,color:h.H.grayScale,children:(0,Z.jsxs)("ul",{children:[(0,Z.jsx)("li",{children:"\uace0\uac1d\uc13c\ud130: 053-123-4567"}),(0,Z.jsx)("li",{children:"\uc2dc\uc2a4\ud15c\uc7a5\uc560\uc2e0\uace0: 053-890-1234"}),(0,Z.jsx)("li",{children:"\uc0c1\ub2f4\uc2dc\uac04: 09:00 ~ 11:30 / 12:30 ~ 18:00 (\ud1a0,\uc77c \uacf5\ud734\uc77c \ud734\ubb34)"}),(0,Z.jsx)("li",{children:"\ubb34\ud1b5\uc7a5\uc785\uae08: \uace0\uae30\ubc45\ud06c 053-456-799202"})]})}),(0,Z.jsxs)("div",{style:{background:"#c2c2c2",paddingBottom:"33px"},children:[(0,Z.jsx)(C,{fontWeight:"bold",color:h.H.g900,children:(0,Z.jsxs)("ul",{children:[(0,Z.jsx)("li",{children:"\ud68c\uc0ac\uc18c\uac1c"}),(0,Z.jsx)("li",{children:"\uc774\uc6a9\uc57d\uad00"}),(0,Z.jsx)("li",{children:"\uac1c\uc778\uc815\ubcf4\ucde8\uae09\ubc29\uce68"}),(0,Z.jsx)("li",{children:"\uc774\uba54\uc77c\ubb34\ub2e8\uc218\uc9d1\uac70\ubd80"}),(0,Z.jsx)("li",{children:"\uc0ac\uc774\ud2b8\uc6b4\uc601\uc815\ucc45"}),(0,Z.jsx)("li",{children:"\uc720\ub8cc\uc11c\ube44\uc2a4\uc774\uc6a9\uc57d\uad00"}),(0,Z.jsx)("li",{children:"\ubc95\uc801\uace0\uc9c0"}),(0,Z.jsx)("li",{children:"\uc804\ubb38\uac00\uc724\ub9ac\uac15\ub839"})]})}),(0,Z.jsx)(k,{}),(0,Z.jsxs)("div",{children:[(0,Z.jsx)(E,{fontWeight:"bold",color:h.H.g900,marginTop:"21px",children:(0,Z.jsx)("ul",{children:(0,Z.jsx)("li",{children:"(\uc8fc)\uace0\uae30\ub85c"})})}),(0,Z.jsx)(E,{color:h.H.g800,children:(0,Z.jsxs)("ul",{children:[(0,Z.jsx)("li",{children:"\ub300\ud45c\uc790: \uae40\uace0\uae30"}),(0,Z.jsx)("li",{children:"\ub4f1\ub85d\ubc88\ud638: 123-45-6789"}),(0,Z.jsx)("li",{children:"\ud1b5\uc2e0\ud310\ub9e4\uc5c5\uc2e0\uace0: 2024-\ub300\uad6c\uc911\uad6c-0001\ud638"}),(0,Z.jsx)("li",{children:"\uc815\ubcf4\ubcf4\ud638 \ucc45\uc784\uc790: \uae40\uace0\uae30 gogi@greenart.co.kr"})]})}),(0,Z.jsx)(E,{color:h.H.g800,marginTop:"1vw",children:(0,Z.jsxs)("ul",{children:[(0,Z.jsx)("li",{children:"\ub300\uad6c\uad11\uc5ed\uc2dc \uc911\uad6c \uace0\uae30\ub85c 92\uae38, \uace0\uae30 192\ud638(\ub0a8\uc0b0\ub3d9, \uace0\uae30\ud3f4\ub9ac\uc2a4\uc9c0\uc2dd\uc0b0\uc5c5\uc13c\ud130)"}),(0,Z.jsx)("li",{children:"\ud638\uc2a4\ud305\uc11c\ube44\uc2a4 \uc81c\uacf5\uc5c5\uccb4: \uace0\uae30\uc694"})]})}),(0,Z.jsx)(E,{color:h.H.g800,children:(0,Z.jsx)("ul",{children:(0,Z.jsx)("li",{children:"Copyright Gogi-ro. All rights reserved."})})}),(0,Z.jsx)(E,{color:h.H.p500,fontWeight:"bold",children:(0,Z.jsx)("ul",{children:(0,Z.jsx)("li",{children:"\ubcf8 \uc0ac\uc774\ud2b8\uc5d0\uc11c \uc81c\uacf5\ub418\ub294 \ubaa8\ub4e0 \uc815\ubcf4\ub294 \uace0\uae43\uc9d1\uc744 \uace0\ub974\ub294 \ub370 \ucc38\uace0\uc790\ub8cc\uc774\uba70, \uc11c\ube44\uc2a4 \uc774\uc6a9\uc5d0 \ub530\ub978 \ucd5c\uc885 \ucc45\uc784\uc740 \uc774\uc6a9\uc790\uc5d0\uac8c \uc788\uc2b5\ub2c8\ub2e4."})})})]})]})]}),S=n=>{let{children:e}=n;return(0,Z.jsxs)("div",{children:[(0,Z.jsx)("header",{children:(0,Z.jsx)(T,{})}),(0,Z.jsx)("main",{children:e}),(0,Z.jsx)("footer",{children:(0,Z.jsx)(L,{})})]})}},3829:(n,e,i)=>{i.r(e),i.d(e,{default:()=>O});var s,t,o,a,l,r,d,c,p,x,g,h,m,j,v,u=i(2791),f=i(7394),b=i(4691),y=i(168),w=i(225);const Z=w.Z.div(s||(s=(0,y.Z)(['\n  font-family: "DAEAM_LEE_TAE_JOON";\n  position: relative;\n  display: block;\n']))),T=w.Z.div(t||(t=(0,y.Z)(["\n  position: relative;\n  /* display: flex; */\n  /* justify-content: center; */\n  /* align-items: flex-start; */\n  width: 100%;\n  height: 800px;\n\n  .TopImage {\n    position: absolute;\n    /* align-items: center; */\n    /* justify-content: center; */\n    width: 1920px;\n    height: 800px;\n  }\n  .TopText {\n    position: absolute;\n    padding-left: 142px;\n    margin-top: 111px;\n    width: auto;\n    height: 265px;\n    /* align-items: center; */\n    /* justify-content: center; */\n  }\n"]))),N=w.Z.div(o||(o=(0,y.Z)(["\n  position: relative;\n  display: block;\n"]))),B=w.Z.div(a||(a=(0,y.Z)(["\n  position: relative;\n  display: flex;\n  gap: 20px;\n"]))),A=w.Z.div(l||(l=(0,y.Z)(["\n  position: relative;\n  display: inline-flex;\n  flex-direction: column;\n  align-items: center;\n  width: 100%;\n\n  .GogiShopTitle {\n    position: relative;\n    padding-top: 177px;\n    font-size: 33px;\n  }\n"]))),C=w.Z.div(r||(r=(0,y.Z)(['\n  display: flex;\n  flex-direction: column;\n  align-items: center;\n  .AboutCardImg {\n    position: relative;\n    padding-top: 14px;\n    width: 583px;\n    height: 360px;\n  }\n  .AboutCardTitle {\n    position: relative;\n    font-size: 33px;\n    padding-top: 20px;\n  }\n  .AboutCardPrice {\n    font-family: "Pretendard";\n    padding-top: 10px;\n    display: inline-flex;\n    font-size: 19px;\n    flex-direction: column;\n    align-items: center;\n  }\n']))),E=w.Z.div(d||(d=(0,y.Z)(["\n  display: flex;\n  padding-top: 20px;\n  .InfoButton {\n    font-size: 19px;\n    color: #d60117;\n    margin-right: 38px;\n  }\n  .BookButton {\n    font-size: 19px;\n    color: #d60117;\n  }\n"]))),k=w.Z.div(c||(c=(0,y.Z)(["\n  position: relative;\n  display: flex;\n  gap: 20px;\n"]))),L=w.Z.div(p||(p=(0,y.Z)(["\n  position: relative;\n  display: inline-flex;\n  flex-direction: column;\n  align-items: center;\n  width: 100%;\n\n  .ButcherTitle {\n    position: relative;\n    padding-top: 177px;\n    font-size: 33px;\n  }\n"]))),S=w.Z.div(x||(x=(0,y.Z)(["\n  position: relative;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  width: 100%;\n  height: 270px;\n  padding-top: 300px;\n  margin-bottom: 134px;\n  /* z-index: 3; */\n\n  img {\n    position: relative;\n    align-items: center;\n    justify-content: center;\n    width: 1920px;\n    height: 354px;\n\n    /* z-index: 1; */\n  }\n  .MainBandText {\n    position: absolute;\n    font-size: 44px;\n    color: #ffffff;\n  }\n"]))),_=w.Z.div(g||(g=(0,y.Z)(['\n  position: relative;\n  display: flex;\n  width: 100%;\n  height: 805px;\n  justify-content: center;\n  padding-top: 63px;\n  flex-shrink: 0;\n  background-color: #f5f5f5;\n\n  .ShopTexts {\n    position: relative;\n    display: flex;\n    flex-direction: column;\n    padding-top: 134px;\n    padding-right: 60px;\n\n    .ShopTexts-one {\n      font-size: 33px;\n      margin-bottom: 9px;\n    }\n    .ShopTexts-two {\n      margin-bottom: 9px;\n      font-size: 44px;\n    }\n    .ShopTexts-three {\n      font-family: "Pretendard";\n      padding-top: 15px;\n      font-size: 19px;\n    }\n    .ShopTexts-four {\n      padding-top: 9px;\n      font-size: 33px;\n    }\n  }\n  img {\n    position: relative;\n    display: flex;\n    justify-content: center;\n    align-items: center;\n    width: 875px;\n    height: 678px;\n  }\n']))),I=w.Z.div(h||(h=(0,y.Z)(["\n  position: relative;\n  display: flex;\n  flex-direction: column;\n  align-items: center;\n  width: 100%;\n  padding-top: 160px;\n  .EventTitle {\n    position: relative;\n    font-size: 33px;\n  }\n"]))),z=w.Z.div(m||(m=(0,y.Z)(["\n  position: relative;\n  display: flex;\n\n  .EventCards {\n    position: relative;\n    display: flex;\n  }\n  .EventImage {\n    position: relative;\n    width: 583px;\n    height: 583px;\n    padding-top: 14px;\n  }\n  .EventButton-wrap {\n    padding-top: 21px;\n  }\n  .EventButton {\n    color: #d60117;\n    font-size: 19px;\n  }\n"]))),M=w.Z.div(j||(j=(0,y.Z)(["\n  display: flex;\n  flex-direction: column;\n  justify-content: center;\n  align-items: center;\n  padding-top: 312px;\n  padding-bottom: 135px;\n\n  .CommunityTitle {\n    font-size: 33px;\n  }\n"]))),P=w.Z.div(v||(v=(0,y.Z)(["\n  position: relative;\n  display: grid;\n  padding-top: 22px;\n  grid-template-columns: repeat(8, 1fr);\n  grid-template-rows: repeat(4, 1fr);\n  grid-column-gap: 20px;\n  grid-row-gap: 20px;\n\n  .BigImage {\n    position: relative;\n    grid-area: 1 / 1 / 5 / 5;\n    img {\n      width: 600px;\n      height: 600px;\n    }\n  }\n  .smallone {\n    position: relative;\n    grid-area: 1 / 5 / 3 / 7;\n    img {\n      width: 290px;\n      height: 290px;\n    }\n  }\n  .smalltwo {\n    position: relative;\n    grid-area: 1 / 7 / 3 / 9;\n    img {\n      width: 290px;\n      height: 290px;\n    }\n  }\n  .smallthree {\n    position: relative;\n    grid-area: 3 / 5 / 5 / 7;\n    img {\n      width: 290px;\n      height: 290px;\n    }\n  }\n  .smallfour {\n    position: relative;\n    grid-area: 3 / 7 / 5 / 9;\n    img {\n      width: 290px;\n      height: 290px;\n    }\n  }\n"])));"".concat("","/api/shop");var H=i(184);const O=()=>{const[n,e]=(0,u.useState)({});n.ishop,n.name,n.pic,n.menu,n.price,n.iboard;return(0,H.jsx)(b.Z,{children:(0,H.jsxs)(Z,{children:[(0,H.jsxs)(T,{children:[(0,H.jsx)("img",{className:"TopImage",src:"/assets/images/aboutimages/main.png"}),(0,H.jsx)("img",{className:"TopText",src:"/assets/images/aboutimages/toptext.png"})]}),(0,H.jsxs)(N,{children:[(0,H.jsxs)(A,{children:[(0,H.jsx)("div",{className:"GogiShopTitle",children:"\uc624\uc9c1 \uace0\uae30-\ub85c\uc5d0\uc11c\ub9cc"}),(0,H.jsxs)(B,{children:[(0,H.jsxs)(C,{children:[(0,H.jsx)("img",{className:"AboutCardImg",src:"/assets/images/aboutimages/gogishop_1.svg"}),(0,H.jsx)("div",{className:"AboutCardTitle",children:"\ub05d\ub3c8 \ub300\uad6c\uc885\ub85c\uc810"}),(0,H.jsx)("div",{className:"AboutCardPrice",children:"\uc0bc\uacb9\uc0b4(130g) 13,000\uc6d0~"}),(0,H.jsxs)(E,{children:[(0,H.jsx)(f.L,{className:"InfoButton",children:"\uc0c1\uc138\ubcf4\uae30"}),(0,H.jsx)(f.L,{className:"BookButton",children:"\uc608\uc57d\ud558\uae30"})]})]}),(0,H.jsxs)(C,{children:[(0,H.jsx)("img",{className:"AboutCardImg",src:"/assets/images/aboutimages/gogishop_1.svg"}),(0,H.jsx)("div",{className:"AboutCardTitle",children:"\ub05d\ub3c8 \ub300\uad6c\uc885\ub85c\uc810"}),(0,H.jsx)("div",{className:"AboutCardPrice",children:"\uc0bc\uacb9\uc0b4(130g) 13,000\uc6d0~"}),(0,H.jsxs)(E,{children:[(0,H.jsx)(f.L,{className:"InfoButton",children:"\uc0c1\uc138\ubcf4\uae30"}),(0,H.jsx)(f.L,{className:"BookButton",children:"\uc608\uc57d\ud558\uae30"})]})]})]})]}),(0,H.jsxs)(L,{children:[(0,H.jsx)("div",{className:"ButcherTitle",children:"\ucea0\ud551\ub3c4 \uace0\uae30-\ub85c\uc640 \ud568\uaed8"}),(0,H.jsxs)(k,{children:[(0,H.jsxs)(C,{children:[(0,H.jsx)("img",{className:"AboutCardImg",src:"/assets/images/aboutimages/butcher_1.svg"}),(0,H.jsx)("div",{className:"AboutCardTitle",children:"\ub0a8\ubb38\ud55c\uc6b0\ubc31\ud654\uc810 \ubd80\ub9bc\ucd95\uc0b0"}),(0,H.jsx)("div",{className:"AboutCardPrice",children:"\ub3fc\uc9c0\uc591\ub150\uac08\ube44 10,000\uc6d0~"}),(0,H.jsxs)(E,{children:[(0,H.jsx)(f.L,{className:"InfoButton",children:"\uc0c1\uc138\ubcf4\uae30"}),(0,H.jsx)(f.L,{className:"BookButton",children:"\ud53d\uc5c5\ud558\uae30"})]})]}),(0,H.jsxs)(C,{children:[(0,H.jsx)("img",{className:"AboutCardImg",src:"/assets/images/aboutimages/butcher_2.svg"}),(0,H.jsx)("div",{className:"AboutCardTitle",children:"\ub0a8\ubb38\ud55c\uc6b0\ubc31\ud654\uc810 \ubd80\ub9bc\ucd95\uc0b0"}),(0,H.jsx)("div",{className:"AboutCardPrice",children:"\ub3fc\uc9c0\uc591\ub150\uac08\ube44 10,000\uc6d0~"}),(0,H.jsxs)(E,{children:[(0,H.jsx)(f.L,{className:"InfoButton",children:"\uc0c1\uc138\ubcf4\uae30"}),(0,H.jsx)(f.L,{className:"BookButton",children:"\ud53d\uc5c5\ud558\uae30"})]})]})]})]}),(0,H.jsxs)(S,{children:[(0,H.jsx)("img",{src:"/assets/images/aboutimages/gogiro_band.svg",alt:"image"}),(0,H.jsx)("span",{className:"MainBandText",children:"\uace0\uae30-\ub85c"})]}),(0,H.jsxs)(_,{children:[(0,H.jsxs)("div",{className:"ShopTexts",children:[(0,H.jsx)("span",{className:"ShopTexts-one",children:"\ubbf8\uce5c \uac00\uc131\ube44 \uace0\uae43\uc9d1"}),(0,H.jsx)("span",{className:"ShopTexts-two",children:":\uc388\ubc24"}),(0,H.jsx)("span",{className:"ShopTexts-three",children:"\uc0bc\uacb9\uc0b4/\ubaa9\uc0b4/\ub9c9\ucc3d 1\uc778\ubd84(150g)"}),(0,H.jsx)("span",{className:"ShopTexts-four",children:"7,900\uc6d0"})]}),(0,H.jsx)("img",{src:"/assets/images/aboutimages/shoppic.svg"})]}),(0,H.jsxs)(I,{children:[(0,H.jsx)("div",{className:"EventTitle",children:"\uc624\ub298\uc758 \ud589\uc0ac"}),(0,H.jsxs)(z,{children:[(0,H.jsxs)(C,{children:[(0,H.jsx)("img",{className:"EventImage",src:"/assets/images/aboutimages/butcher_3.svg"}),(0,H.jsx)("div",{className:"AboutCardTitle",children:"\uc2e0\ubbf8\uc2dd\uc721\uc810"}),(0,H.jsx)("div",{className:"AboutCardPrice",children:"\ucd5c\ub300 30% \ud560\uc778 \ud589\uc0ac"}),(0,H.jsx)("div",{className:"EventButton-wrap",children:(0,H.jsx)(f.L,{className:"EventButton",children:"\ubc29\ubb38\ud558\uae30"})})]}),(0,H.jsxs)(C,{children:[(0,H.jsx)("img",{className:"EventImage",src:"/assets/images/aboutimages/butcher_3.svg"}),(0,H.jsx)("div",{className:"AboutCardTitle",children:"\uc2e0\ubbf8\uc2dd\uc721\uc810"}),(0,H.jsx)("div",{className:"AboutCardPrice",children:"\ucd5c\ub300 30% \ud560\uc778 \ud589\uc0ac"}),(0,H.jsx)("div",{className:"EventButton-wrap",children:(0,H.jsx)(f.L,{className:"EventButton",children:"\ubc29\ubb38\ud558\uae30"})})]})]})]}),(0,H.jsxs)(M,{children:[(0,H.jsx)("span",{className:"CommunityTitle",children:"\uace0\uae30 \uc7a1\ub2f4"}),(0,H.jsxs)(P,{children:[(0,H.jsx)("div",{className:"BigImage",children:(0,H.jsx)("img",{src:"/assets/images/aboutimages/community_1.svg"})}),(0,H.jsx)("div",{className:"smallone",children:(0,H.jsx)("img",{src:"/assets/images/aboutimages/community_2.svg"})}),(0,H.jsx)("div",{className:"smalltwo",children:(0,H.jsx)("img",{src:"/assets/images/aboutimages/community_3.svg"})}),(0,H.jsx)("div",{className:"smallthree",children:(0,H.jsx)("img",{src:"/assets/images/aboutimages/community_4.svg"})}),(0,H.jsx)("div",{className:"smallfour",children:(0,H.jsx)("img",{src:"/assets/images/aboutimages/community_5.svg"})})]})]})]})]})})}},2132:(n,e,i)=>{i.d(e,{o:()=>t,q:()=>s});const s=(n,e)=>n||e,t=(n,e)=>n||e}}]);
//# sourceMappingURL=829.8ec63cb1.chunk.js.map