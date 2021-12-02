"use strict";(self.webpackChunkdocs=self.webpackChunkdocs||[]).push([[736],{3905:function(e,t,n){n.d(t,{Zo:function(){return u},kt:function(){return d}});var r=n(7294);function o(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function i(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function a(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?i(Object(n),!0).forEach((function(t){o(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):i(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function c(e,t){if(null==e)return{};var n,r,o=function(e,t){if(null==e)return{};var n,r,o={},i=Object.keys(e);for(r=0;r<i.length;r++)n=i[r],t.indexOf(n)>=0||(o[n]=e[n]);return o}(e,t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(e);for(r=0;r<i.length;r++)n=i[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(o[n]=e[n])}return o}var l=r.createContext({}),s=function(e){var t=r.useContext(l),n=t;return e&&(n="function"==typeof e?e(t):a(a({},t),e)),n},u=function(e){var t=s(e.components);return r.createElement(l.Provider,{value:t},e.children)},m={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},p=r.forwardRef((function(e,t){var n=e.components,o=e.mdxType,i=e.originalType,l=e.parentName,u=c(e,["components","mdxType","originalType","parentName"]),p=s(n),d=o,f=p["".concat(l,".").concat(d)]||p[d]||m[d]||i;return n?r.createElement(f,a(a({ref:t},u),{},{components:n})):r.createElement(f,a({ref:t},u))}));function d(e,t){var n=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var i=n.length,a=new Array(i);a[0]=p;var c={};for(var l in t)hasOwnProperty.call(t,l)&&(c[l]=t[l]);c.originalType=e,c.mdxType="string"==typeof e?e:o,a[1]=c;for(var s=2;s<i;s++)a[s]=n[s];return r.createElement.apply(null,a)}return r.createElement.apply(null,n)}p.displayName="MDXCreateElement"},3919:function(e,t,n){function r(e){return!0===/^(\w*:|\/\/)/.test(e)}function o(e){return void 0!==e&&!r(e)}n.d(t,{b:function(){return r},Z:function(){return o}})},4996:function(e,t,n){n.d(t,{C:function(){return i},Z:function(){return a}});var r=n(2263),o=n(3919);function i(){var e=(0,r.Z)().siteConfig,t=(e=void 0===e?{}:e).baseUrl,n=void 0===t?"/":t,i=e.url;return{withBaseUrl:function(e,t){return function(e,t,n,r){var i=void 0===r?{}:r,a=i.forcePrependBaseUrl,c=void 0!==a&&a,l=i.absolute,s=void 0!==l&&l;if(!n)return n;if(n.startsWith("#"))return n;if((0,o.b)(n))return n;if(c)return t+n;var u=n.startsWith(t)?n:t+n.replace(/^\//,"");return s?e+u:u}(i,n,e,t)}}}function a(e,t){return void 0===t&&(t={}),(0,i().withBaseUrl)(e,t)}},5527:function(e,t,n){n.d(t,{M:function(){return c}});var r=n(7294),o="container_3Maz",i="code_1u2W",a="img_34ER",c=function(e){var t=e.children,n=e.imageUrl,c=e.width,l=e.height;return r.createElement("div",{className:o},r.createElement("div",{className:i},t),r.createElement("img",{className:a,src:n,width:c,height:l,alt:"",loading:"lazy"}))}},7266:function(e,t,n){n.r(t),n.d(t,{frontMatter:function(){return s},contentTitle:function(){return u},metadata:function(){return m},toc:function(){return p},default:function(){return f}});var r=n(7462),o=n(3366),i=(n(7294),n(3905)),a=n(5527),c=n(4996),l=["components"],s={sidebar_position:1},u="Compose Theme",m={unversionedId:"main/extensions/compose-theme",id:"main/extensions/compose-theme",isDocsHomePage:!1,title:"Compose Theme",description:"There is the extension to change the Compose Theme.",source:"@site/docs/main/extensions/compose-theme.mdx",sourceDirName:"main/extensions",slug:"/main/extensions/compose-theme",permalink:"/katalog/docs/main/extensions/compose-theme",editUrl:"https://github.com/cyberagent-zemi/katalog/edit/main/docs/docs/main/extensions/compose-theme.mdx",tags:[],version:"current",sidebarPosition:1,frontMatter:{sidebar_position:1},sidebar:"tutorialSidebar",previous:{title:"Fragment",permalink:"/katalog/docs/main/fragment"},next:{title:"Android Theme",permalink:"/katalog/docs/main/extensions/android-theme"}},p=[{value:"Setup",id:"setup",children:[],level:2},{value:"Examples",id:"examples",children:[],level:2}],d={toc:p};function f(e){var t=e.components,n=(0,o.Z)(e,l);return(0,i.kt)("wrapper",(0,r.Z)({},d,n,{components:t,mdxType:"MDXLayout"}),(0,i.kt)("h1",{id:"compose-theme"},"Compose Theme"),(0,i.kt)("p",null,"There is the extension to change the Compose Theme."),(0,i.kt)("h2",{id:"setup"},"Setup"),(0,i.kt)("p",null,"Add the ",(0,i.kt)("inlineCode",{parentName:"p"},"katalog-ext-theme")," package."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-kotlin"},'dependencies {\n    implementation("jp.co.cyberagent.katalog:katalog:`LATEST_VERSION`")\n    implementation("jp.co.cyberagent.katalog:katalog-ext-theme:`LATEST_VERSION`")\n}\n')),(0,i.kt)("h2",{id:"examples"},"Examples"),(0,i.kt)(a.M,{imageUrl:(0,c.Z)("/img/docs/compose-theme.png"),width:1080,height:2280,mdxType:"Preview"},(0,i.kt)("p",null,"You can set the Material Theme when calling ",(0,i.kt)("inlineCode",{parentName:"p"},"registerKatalog"),".\nThe ",(0,i.kt)("inlineCode",{parentName:"p"},"background")," color will be applied automatically.\nDon't forget to set the ",(0,i.kt)("inlineCode",{parentName:"p"},"content"),"."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-kotlin"},'registerKatalog(\n    title = "Android Sample",\n    extensions = listOf(\n        ThemeExt { content ->\n            MaterialTheme(\n                colors = MaterialTheme.colors.copy(\n                    background = Color.Red\n                ),\n                content = content\n            )\n        }\n    )\n) {\n    compose("Text") {\n        Text(text = "Hello, World")\n    }\n}\n'))))}f.isMDXComponent=!0}}]);