"use strict";(self.webpackChunkteam1_project=self.webpackChunkteam1_project||[]).push([[208],{1208:(n,e,t)=>{t.r(e),t.d(e,{default:()=>yn});var i=t(2791),r=t(168),o=t(4238),a=t(7462);const l=i.useLayoutEffect;var s=function(n,e){"function"!==typeof n?n.current=e:n(e)};const d=function(n,e){var t=(0,i.useRef)();return(0,i.useCallback)((function(i){n.current=i,t.current&&s(t.current,null),t.current=e,e&&s(e,i)}),[e])};var c={"min-height":"0","max-height":"none",height:"0",visibility:"hidden",overflow:"hidden",position:"absolute","z-index":"-1000",top:"0",right:"0"},p=function(n){Object.keys(c).forEach((function(e){n.style.setProperty(e,c[e],"important")}))},x=null,h=function(n,e){var t=n.scrollHeight;return"border-box"===e.sizingStyle.boxSizing?t+e.borderSize:t-e.paddingSize};var u=function(){},g=["borderBottomWidth","borderLeftWidth","borderRightWidth","borderTopWidth","boxSizing","fontFamily","fontSize","fontStyle","fontWeight","letterSpacing","lineHeight","paddingBottom","paddingLeft","paddingRight","paddingTop","tabSize","textIndent","textRendering","textTransform","width","wordBreak"],f=!!document.documentElement.currentStyle,m=function(n){var e=window.getComputedStyle(n);if(null===e)return null;var t,i=(t=e,g.reduce((function(n,e){return n[e]=t[e],n}),{})),r=i.boxSizing;return""===r?null:(f&&"border-box"===r&&(i.width=parseFloat(i.width)+parseFloat(i.borderRightWidth)+parseFloat(i.borderLeftWidth)+parseFloat(i.paddingRight)+parseFloat(i.paddingLeft)+"px"),{sizingStyle:i,paddingSize:parseFloat(i.paddingBottom)+parseFloat(i.paddingTop),borderSize:parseFloat(i.borderBottomWidth)+parseFloat(i.borderTopWidth)})};function b(n,e,t){var r=function(n){var e=i.useRef(n);return l((function(){e.current=n})),e}(t);i.useLayoutEffect((function(){var t=function(n){return r.current(n)};if(n)return n.addEventListener(e,t),function(){return n.removeEventListener(e,t)}}),[])}var v,y,j,Z,w,E,k,z,_,S,R,A,L,O,C,F,M,T,W,H,N,D,I,J,B,P=["cacheMeasurements","maxRows","minRows","onChange","onHeightChange"],U=function(n,e){var t=n.cacheMeasurements,r=n.maxRows,o=n.minRows,l=n.onChange,s=void 0===l?u:l,c=n.onHeightChange,g=void 0===c?u:c,f=function(n,e){if(null==n)return{};var t,i,r={},o=Object.keys(n);for(i=0;i<o.length;i++)t=o[i],e.indexOf(t)>=0||(r[t]=n[t]);return r}(n,P),v=void 0!==f.value,y=i.useRef(null),j=d(y,e),Z=i.useRef(0),w=i.useRef(),E=function(){var n=y.current,e=t&&w.current?w.current:m(n);if(e){w.current=e;var i=function(n,e,t,i){void 0===t&&(t=1),void 0===i&&(i=1/0),x||((x=document.createElement("textarea")).setAttribute("tabindex","-1"),x.setAttribute("aria-hidden","true"),p(x)),null===x.parentNode&&document.body.appendChild(x);var r=n.paddingSize,o=n.borderSize,a=n.sizingStyle,l=a.boxSizing;Object.keys(a).forEach((function(n){var e=n;x.style[e]=a[e]})),p(x),x.value=e;var s=h(x,n);x.value=e,s=h(x,n),x.value="x";var d=x.scrollHeight-r,c=d*t;"border-box"===l&&(c=c+r+o),s=Math.max(c,s);var u=d*i;return"border-box"===l&&(u=u+r+o),[s=Math.min(u,s),d]}(e,n.value||n.placeholder||"x",o,r),a=i[0],l=i[1];Z.current!==a&&(Z.current=a,n.style.setProperty("height",a+"px","important"),g(a,{rowHeight:l}))}};return i.useLayoutEffect(E),b(window,"resize",E),function(n){b(document.fonts,"loadingdone",n)}(E),i.createElement("textarea",(0,a.Z)({},f,{onChange:function(n){v||E(),s(n)},ref:j}))},q=i.forwardRef(U),G=t(8096);const K=o.Z.div(v||(v=(0,r.Z)(["\n  display: flex;\n  flex-direction: column;\n  align-items: center;\n  gap: 15px;\n  padding: 0px 0px 30px 0px;\n"]))),Q=o.Z.div(y||(y=(0,r.Z)(["\n  display: flex;\n  flex-direction: column;\n  align-items: center;\n"]))),V=o.Z.div(j||(j=(0,r.Z)(["\n  display: flex;\n  padding: 30px 10px;\n  justify-content: center;\n  align-items: center;\n  gap: 10px;\n  span {\n    color: #000;\n    text-align: center;\n    font-family: DAEAM_LEE_TAE_JOON;\n    font-size: 33px;\n    font-style: normal;\n    font-weight: 400;\n    line-height: 125%; /* 41.25px */\n  }\n"]))),X=o.Z.div(Z||(Z=(0,r.Z)(["\n  display: flex;\n  padding: 30px 0px;\n  align-items: flex-start;\n  gap: 30px;\n"]))),Y=o.Z.div(w||(w=(0,r.Z)(["\n  display: flex;\n  width: 530px;\n  height: 450px;\n  align-items: flex-start;\n  align-content: flex-start;\n  gap: 30px 40px;\n  flex-wrap: wrap;\n"]))),$=o.Z.div(E||(E=(0,r.Z)(["\n  display: flex;\n  width: 530px;\n  align-items: center;\n  flex-shrink: 0;\n"]))),nn=o.Z.div(k||(k=(0,r.Z)(["\n  display: flex;\n  width: 164px;\n  height: 40px;\n  flex-direction: column;\n  justify-content: center;\n  flex-shrink: 0;\n  span {\n    color: #000;\n    font-family: DAEAM_LEE_TAE_JOON;\n    font-size: 25px;\n    font-style: normal;\n    font-weight: 400;\n    line-height: 125%; /* 31.25px */\n  }\n"]))),en=o.Z.div(z||(z=(0,r.Z)(["\n  display: flex;\n  width: 366px;\n  height: 40px;\n  flex-direction: column;\n  justify-content: center;\n  flex-shrink: 0;\n  span {\n    color: #000;\n    font-family: DAEAM_LEE_TAE_JOON;\n    font-size: 25px;\n    font-style: normal;\n    font-weight: 400;\n    line-height: 125%; /* 31.25px */\n  }\n"]))),tn=o.Z.div(_||(_=(0,r.Z)(["\n  display: flex;\n  width: 364px;\n  align-items: center;\n  gap: 10px;\n  background-image: ",";\n"])),(n=>{let{Rating:e,rating:t}=n;return e<=t?"red":"blue"})),rn=o.Z.img(S||(S=(0,r.Z)(["\n  width: 50px;\n  height: 50px;\n  flex-shrink: 0;\n"]))),on=o.Z.div(R||(R=(0,r.Z)(["\n  display: flex;\n  align-items: flex-start;\n  width: 530px;\n  flex-shrink: 0;\n"]))),an=o.Z.div(A||(A=(0,r.Z)(["\n  display: flex;\n  flex-direction: column;\n  justify-content: center;\n  align-items: flex-start;\n"]))),ln=o.Z.div(L||(L=(0,r.Z)(["\n  display: flex;\n  width: 164px;\n  height: 30px;\n  flex-direction: column;\n  justify-content: center;\n  span {\n    color: #000;\n    font-family: DAEAM_LEE_TAE_JOON;\n    font-size: 25px;\n    font-style: normal;\n    font-weight: 400;\n    line-height: 125%; /* 31.25px */\n  }\n"]))),sn=o.Z.div(O||(O=(0,r.Z)(["\n  display: flex;\n  width: 164px;\n  height: auto;\n  flex-direction: column;\n  justify-content: center;\n  span {\n    color: var(--gray-scale-500, #8f8f8f);\n    /* Rugular 11 */\n    font-family: Pretendard;\n    font-size: 11px;\n    font-style: normal;\n    font-weight: 400;\n    line-height: 125%; /* 13.75px */\n  }\n"]))),dn=o.Z.div(C||(C=(0,r.Z)(["\n  padding-top: 10px;\n  width: 366px;\n"]))),cn=(0,o.Z)(q)(F||(F=(0,r.Z)(['\n  width: 366px;\n  resize: none;\n  font-size: 14px;\n  font-family: "Pretendard";\n  border: none;\n  border-bottom: 1px solid ',';\n  padding-bottom: "5px";\n  overflow: hidden;\n'])),G.H.g700),pn=o.Z.div(M||(M=(0,r.Z)(["\n  position: relative;\n  display: flex;\n  width: 370px;\n  height: 450px;\n  flex-direction: column;\n  align-items: center;\n  gap: 30px;\n"]))),xn=o.Z.label(T||(T=(0,r.Z)(["\n  background-image: url(",");\n  position: absolute;\n  top: 0;\n  left: 10px;\n  z-index: 10;\n  width: 350px;\n  height: 350px;\n  aspect-ratio: 1/1;\n  border: none;\n  background-repeat: no-repeat;\n  background-size: cover;\n"])),(n=>{let{mainImageSelect:e}=n;return e})),hn=o.Z.input(W||(W=(0,r.Z)(["\n  display: none;\n"]))),un=o.Z.div(H||(H=(0,r.Z)(["\n  position: relative;\n  width: 350px;\n  aspect-ratio: 1/1;\n  background-color: #000;\n  img {\n    width: 350px;\n    height: 350px;\n    aspect-ratio: 1/1;\n  }\n"]))),gn=o.Z.div(N||(N=(0,r.Z)(["\n  /* position: relative; */\n  padding-top: 10px;\n  display: flex;\n  gap: 10px;\n"]))),fn=o.Z.div(D||(D=(0,r.Z)(["\n  border: 1px solid ",';\n  border-radius: 5px;\n  width: 60px;\n  height: 60px;\n  /* background: blue; */\n  /* background-image: url("../public/sub_image_select.png"); */\n  background-repeat: no-repeat;\n  background-size: cover;\n  img {\n    width: 100%;\n    height: auto;\n    /* border-radius: 10px; */\n  }\n'])),G.H.g500),mn=o.Z.button(I||(I=(0,r.Z)(["\n  position: absolute;\n  margin-left: -20px;\n  z-index: 100000000;\n  width: 20px;\n  height: 20px;\n  background: none;\n  background-image: url(",");\n  background-size: cover;\n  background-repeat: no-repeat;\n  border: none;\n"])),(n=>{let{bgImg:e}=n;return e})),bn=(o.Z.div(J||(J=(0,r.Z)(["\n  display: flex;\n  width: 216px;\n  height: 33px;\n  flex-direction: column;\n  justify-content: center;\n  flex-shrink: 0;\n  span {\n    color: #000;\n    text-align: center;\n    font-family: DAEAM_LEE_TAE_JOON;\n    font-size: 14px;\n    font-style: normal;\n    font-weight: 400;\n    line-height: 125%; /* 17.5px */\n  }\n"]))),o.Z.button(B||(B=(0,r.Z)(["\n  display: flex;\n  padding: 10px 20px;\n  flex-direction: column;\n  justify-content: center;\n  align-items: center;\n  gap: 10px;\n  border-radius: 10px;\n  border: 2px solid var(--sub, #066e52);\n  background: #fff;\n  span {\n    color: var(--primary, #d60117);\n    text-align: center;\n    font-family: DAEAM_LEE_TAE_JOON;\n    font-size: 19px;\n    font-style: normal;\n    font-weight: 400;\n    line-height: 125%; /* 23.75px */\n  }\n"]))));var vn=t(184);const yn=()=>{const[n,e]=(0,i.useState)(1),t="/assets/images/delete_button.svg",[r,o]=(0,i.useState)(null),[a,l]=(0,i.useState)([]);return(0,vn.jsx)("div",{children:(0,vn.jsxs)(K,{children:[(0,vn.jsxs)(Q,{children:[(0,vn.jsx)(V,{children:(0,vn.jsx)("span",{children:"\ub9ac\ubdf0\uc4f0\uae30"})}),(0,vn.jsxs)(X,{children:[(0,vn.jsxs)(Y,{children:[(0,vn.jsxs)($,{children:[(0,vn.jsx)(nn,{children:(0,vn.jsx)("span",{children:"\uac00\uac8c\uba85"})}),(0,vn.jsx)(en,{children:(0,vn.jsx)("span",{children:"\ubaa9\uad6c\uba4d"})})]}),(0,vn.jsxs)($,{children:[(0,vn.jsx)(nn,{children:(0,vn.jsx)("span",{children:"\ub0a0\uc9dc"})}),(0,vn.jsx)(en,{children:(0,vn.jsx)("span",{children:"2024.01.11"})})]}),(0,vn.jsxs)($,{children:[(0,vn.jsx)(nn,{children:(0,vn.jsx)("span",{children:"\ubcc4\uc810"})}),(0,vn.jsx)(tn,{children:[1,2,3,4,5].map((t=>(0,vn.jsx)(rn,{src:t<=n?"/assets/images/star_count.svg":"/assets/images/star_no_count.svg",alt:"",onClick:()=>{return e(n=t),void console.log(n);var n}},t)))})]}),(0,vn.jsxs)(on,{children:[(0,vn.jsxs)(an,{children:[(0,vn.jsx)(ln,{children:(0,vn.jsx)("span",{children:"\ucf54\uba58\ud2b8"})}),(0,vn.jsx)(sn,{children:(0,vn.jsx)("span",{children:"(300\uc790 \uc81c\ud55c)"})})]}),(0,vn.jsx)(dn,{children:(0,vn.jsx)(cn,{maxRows:15,minRows:1,placeholder:"\ub9ac\ubdf0\ub97c \uc791\uc131\ud574\uc8fc\uc138\uc694.",height:375})})]})]}),(0,vn.jsxs)(pn,{children:[(0,vn.jsx)(xn,{htmlFor:"main-page",mainImageSelect:"/assets/images/main_image_select.png",children:(0,vn.jsx)(hn,{type:"file",multiple:!0,onChange:n=>{const e=n.target.files;if((r?e.length+1:e.length)+a.length>5)return void alert("\ucd5c\ub300 5\uac1c\uc758 \uc774\ubbf8\uc9c0\ub9cc \uc5c5\ub85c\ub4dc \uac00\ub2a5\ud569\ub2c8\ub2e4.");let t=r;const i=[...a];for(let r=0;r<e.length;r++){const n=e[r],o=URL.createObjectURL(n);t?i.length<4&&i.push(o):t=o}o(t),l(i)},id:"main-page"})}),(0,vn.jsxs)("div",{children:[r&&(0,vn.jsxs)(un,{children:[(0,vn.jsx)("img",{src:r,alt:"Main"}),(0,vn.jsx)(mn,{onClick:()=>{if(a.length>0){const n=a[0],e=a.slice(1);o(n),l(e)}else o(null)},bgImg:t})]}),(0,vn.jsx)(gn,{children:a.map(((n,e)=>(0,vn.jsxs)(fn,{children:[(0,vn.jsx)("img",{src:n,alt:"Sub ".concat(e)}),(0,vn.jsx)(mn,{onClick:()=>(n=>{0!==n||r||o(a[1]||null),l(a.filter(((e,t)=>t!==n)))})(e),bgImg:t})]},e)))})]})]})]})]}),(0,vn.jsx)(bn,{children:(0,vn.jsx)("span",{children:"\uc791\uc131\uc644\ub8cc"})})]})})}}}]);
//# sourceMappingURL=208.e386d851.chunk.js.map