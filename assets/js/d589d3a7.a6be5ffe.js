"use strict";(self.webpackChunkdocs=self.webpackChunkdocs||[]).push([[162],{3905:function(e,t,n){n.d(t,{Zo:function(){return s},kt:function(){return g}});var r=n(7294);function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){a(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function p(e,t){if(null==e)return{};var n,r,a=function(e,t){if(null==e)return{};var n,r,a={},o=Object.keys(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||(a[n]=e[n]);return a}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(a[n]=e[n])}return a}var l=r.createContext({}),c=function(e){var t=r.useContext(l),n=t;return e&&(n="function"==typeof e?e(t):i(i({},t),e)),n},s=function(e){var t=c(e.components);return r.createElement(l.Provider,{value:t},e.children)},u={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},d=r.forwardRef((function(e,t){var n=e.components,a=e.mdxType,o=e.originalType,l=e.parentName,s=p(e,["components","mdxType","originalType","parentName"]),d=c(n),g=a,m=d["".concat(l,".").concat(g)]||d[g]||u[g]||o;return n?r.createElement(m,i(i({ref:t},s),{},{components:n})):r.createElement(m,i({ref:t},s))}));function g(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var o=n.length,i=new Array(o);i[0]=d;var p={};for(var l in t)hasOwnProperty.call(t,l)&&(p[l]=t[l]);p.originalType=e,p.mdxType="string"==typeof e?e:a,i[1]=p;for(var c=2;c<o;c++)i[c]=n[c];return r.createElement.apply(null,i)}return r.createElement.apply(null,n)}d.displayName="MDXCreateElement"},5527:function(e,t,n){n.d(t,{M:function(){return p}});var r=n(7294),a="container_3Maz",o="code_1u2W",i="img_34ER",p=function(e){var t=e.children,n=e.imageUrl,p=e.width,l=e.height;return r.createElement("div",{className:a},r.createElement("div",{className:o},t),r.createElement("img",{className:i,src:n,width:p,height:l,alt:"",loading:"lazy"}))}},9390:function(e,t,n){n.r(t),n.d(t,{frontMatter:function(){return l},contentTitle:function(){return c},metadata:function(){return s},toc:function(){return u},default:function(){return g}});var r=n(7462),a=n(3366),o=(n(7294),n(3905)),i=n(5527),p=["components"],l={sidebar_position:1},c="Getting Started",s={unversionedId:"getting-started",id:"getting-started",isDocsHomePage:!1,title:"Getting Started",description:"step1: Add the dependency",source:"@site/docs/getting-started.md",sourceDirName:".",slug:"/getting-started",permalink:"/docs/getting-started",editUrl:"https://github.com/cyberagent-zemi/katalog/edit/main/docs/docs/getting-started.md",tags:[],version:"current",sidebarPosition:1,frontMatter:{sidebar_position:1},sidebar:"tutorialSidebar",next:{title:"Register and Start",permalink:"/docs/main/register-and-start"}},u=[{value:"step1: Add the dependency",id:"step1-add-the-dependency",children:[],level:2},{value:"step2: Register the UI component",id:"step2-register-the-ui-component",children:[],level:2},{value:"step3: Start Catalog Activity",id:"step3-start-catalog-activity",children:[],level:2}],d={toc:u};function g(e){var t=e.components,n=(0,a.Z)(e,p);return(0,o.kt)("wrapper",(0,r.Z)({},d,n,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("h1",{id:"getting-started"},"Getting Started"),(0,o.kt)("h2",{id:"step1-add-the-dependency"},"step1: Add the dependency"),(0,o.kt)("p",null,"Add GitHub Packages repository to your build.gradle file.\nSet your ",(0,o.kt)("inlineCode",{parentName:"p"},"GITHUB_USERNAME")," and ",(0,o.kt)("inlineCode",{parentName:"p"},"GITHUB_TOKEN"),"."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},'repositories {\n    maven {\n        name = "GitHubPackages"\n        url = uri("https://maven.pkg.github.com/cyberagent-zemi/katalog")\n        credentials {\n            username = `GITHUB_USERNAME`\n            password = `GITHUB_TOKEN`\n        }\n    }\n}\n')),(0,o.kt)("p",null,"Add the package dependencies to your build.gradle file.\nPlease check ",(0,o.kt)("inlineCode",{parentName:"p"},"LATEST_VERSION")," from ",(0,o.kt)("a",{parentName:"p",href:"https://github.com/cyberagent-zemi/katalog/packages/886303"},"here"),"."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},'dependencies {\n    implementation("co.jp.cyberagent.katalog:katalog-android:`LATEST_VERSION`")\n}\n')),(0,o.kt)("h2",{id:"step2-register-the-ui-component"},"step2: Register the UI component"),(0,o.kt)(i.M,{imageUrl:"/img/docs/start.png",width:1080,height:2280,mdxType:"Preview"},(0,o.kt)("p",null,"Just run the ",(0,o.kt)("inlineCode",{parentName:"p"},"registerKatalog")," function in your application.\nTo register a ",(0,o.kt)("inlineCode",{parentName:"p"},"Composable"),", use the ",(0,o.kt)("inlineCode",{parentName:"p"},"compose")," function."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},'class MyApplication : Application() {\n    override fun onCreate() {\n        super.onCreate()\n\n        registerKatalog(\n            title = "My App Catalog"\n        ) {\n            compose("UI Component") {\n                Text(text = "Hello, World")\n            }\n        }\n    }\n}\n'))),(0,o.kt)(i.M,{imageUrl:"/img/docs/group.png",width:1080,height:2280,mdxType:"Preview"},(0,o.kt)("p",null,"You can use the ",(0,o.kt)("inlineCode",{parentName:"p"},"group")," function to group components."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},'registerKatalog(\n    title = "My App Catalog"\n) {\n    group("Group 1") {\n        compose("UI Component") {\n            /* ... */\n        }\n    }\n\n    group("Group 2") {\n        /* ... */\n    }\n}\n')),(0,o.kt)("p",null,"The ",(0,o.kt)("inlineCode",{parentName:"p"},"group")," can also be assigned to a variable."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},'val group1 = group("Group 1") {\n    /* ... */\n}\nval group2 = group("Group 2") {\n    /* ... */\n}\nregisterKatalog {\n    title = "My App Catalog"\n    group(group1, group2)\n}\n'))),(0,o.kt)("h2",{id:"step3-start-catalog-activity"},"step3: Start Catalog Activity"),(0,o.kt)("p",null,"Start ",(0,o.kt)("inlineCode",{parentName:"p"},"KatalogActivity")," from your debug menu."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},"KatalogActivity.start(activity)\n")))}g.isMDXComponent=!0}}]);