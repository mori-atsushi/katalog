"use strict";(self.webpackChunkdocs=self.webpackChunkdocs||[]).push([[668,923],{3905:function(e,t,a){a.d(t,{Zo:function(){return c},kt:function(){return f}});var n=a(7294);function r(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}function l(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,n)}return a}function o(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?l(Object(a),!0).forEach((function(t){r(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):l(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}function i(e,t){if(null==e)return{};var a,n,r=function(e,t){if(null==e)return{};var a,n,r={},l=Object.keys(e);for(n=0;n<l.length;n++)a=l[n],t.indexOf(a)>=0||(r[a]=e[a]);return r}(e,t);if(Object.getOwnPropertySymbols){var l=Object.getOwnPropertySymbols(e);for(n=0;n<l.length;n++)a=l[n],t.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(e,a)&&(r[a]=e[a])}return r}var u=n.createContext({}),s=function(e){var t=n.useContext(u),a=t;return e&&(a="function"==typeof e?e(t):o(o({},t),e)),a},c=function(e){var t=s(e.components);return n.createElement(u.Provider,{value:t},e.children)},p="mdxType",m={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},d=n.forwardRef((function(e,t){var a=e.components,r=e.mdxType,l=e.originalType,u=e.parentName,c=i(e,["components","mdxType","originalType","parentName"]),p=s(a),d=r,f=p["".concat(u,".").concat(d)]||p[d]||m[d]||l;return a?n.createElement(f,o(o({ref:t},c),{},{components:a})):n.createElement(f,o({ref:t},c))}));function f(e,t){var a=arguments,r=t&&t.mdxType;if("string"==typeof e||r){var l=a.length,o=new Array(l);o[0]=d;var i={};for(var u in t)hasOwnProperty.call(t,u)&&(i[u]=t[u]);i.originalType=e,i[p]="string"==typeof e?e:r,o[1]=i;for(var s=2;s<l;s++)o[s]=a[s];return n.createElement.apply(null,o)}return n.createElement.apply(null,a)}d.displayName="MDXCreateElement"},5354:function(e,t,a){a.r(t),a.d(t,{contentTitle:function(){return S},default:function(){return D},frontMatter:function(){return O},metadata:function(){return V},toc:function(){return j}});var n=a(3117),r=a(7294),l=a(3905),o=a(5527),i=a(4996),u=a(8003),s=a(6010),c=a(2466),p=a(6550),m=a(1980),d=a(7392),f=a(12);function h(e){return function(e){return r.Children.map(e,(e=>{if(!e||(0,r.isValidElement)(e)&&function(e){const{props:t}=e;return!!t&&"object"==typeof t&&"value"in t}(e))return e;throw new Error(`Docusaurus error: Bad <Tabs> child <${"string"==typeof e.type?e.type:e.type.name}>: all children of the <Tabs> component should be <TabItem>, and every <TabItem> should have a unique "value" prop.`)}))?.filter(Boolean)??[]}(e).map((e=>{let{props:{value:t,label:a,attributes:n,default:r}}=e;return{value:t,label:a,attributes:n,default:r}}))}function g(e){const{values:t,children:a}=e;return(0,r.useMemo)((()=>{const e=t??h(a);return function(e){const t=(0,d.l)(e,((e,t)=>e.value===t.value));if(t.length>0)throw new Error(`Docusaurus error: Duplicate values "${t.map((e=>e.value)).join(", ")}" found in <Tabs>. Every value needs to be unique.`)}(e),e}),[t,a])}function b(e){let{value:t,tabValues:a}=e;return a.some((e=>e.value===t))}function k(e){let{queryString:t=!1,groupId:a}=e;const n=(0,p.k6)(),l=function(e){let{queryString:t=!1,groupId:a}=e;if("string"==typeof t)return t;if(!1===t)return null;if(!0===t&&!a)throw new Error('Docusaurus error: The <Tabs> component groupId prop is required if queryString=true, because this value is used as the search param name. You can also provide an explicit value such as queryString="my-search-param".');return a??null}({queryString:t,groupId:a});return[(0,m._X)(l),(0,r.useCallback)((e=>{if(!l)return;const t=new URLSearchParams(n.location.search);t.set(l,e),n.replace({...n.location,search:t.toString()})}),[l,n])]}function v(e){const{defaultValue:t,queryString:a=!1,groupId:n}=e,l=g(e),[o,i]=(0,r.useState)((()=>function(e){let{defaultValue:t,tabValues:a}=e;if(0===a.length)throw new Error("Docusaurus error: the <Tabs> component requires at least one <TabItem> children component");if(t){if(!b({value:t,tabValues:a}))throw new Error(`Docusaurus error: The <Tabs> has a defaultValue "${t}" but none of its children has the corresponding value. Available values are: ${a.map((e=>e.value)).join(", ")}. If you intend to show no default tab, use defaultValue={null} instead.`);return t}const n=a.find((e=>e.default))??a[0];if(!n)throw new Error("Unexpected error: 0 tabValues");return n.value}({defaultValue:t,tabValues:l}))),[u,s]=k({queryString:a,groupId:n}),[c,p]=function(e){let{groupId:t}=e;const a=function(e){return e?`docusaurus.tab.${e}`:null}(t),[n,l]=(0,f.Nk)(a);return[n,(0,r.useCallback)((e=>{a&&l.set(e)}),[a,l])]}({groupId:n}),m=(()=>{const e=u??c;return b({value:e,tabValues:l})?e:null})();(0,r.useLayoutEffect)((()=>{m&&i(m)}),[m]);return{selectedValue:o,selectValue:(0,r.useCallback)((e=>{if(!b({value:e,tabValues:l}))throw new Error(`Can't select invalid tab value=${e}`);i(e),s(e),p(e)}),[s,p,l]),tabValues:l}}var y=a(2389),w={tabList:"tabList__CuJ",tabItem:"tabItem_LNqP"};function N(e){let{className:t,block:a,selectedValue:l,selectValue:o,tabValues:i}=e;const u=[],{blockElementScrollPositionUntilNextRender:p}=(0,c.o5)(),m=e=>{const t=e.currentTarget,a=u.indexOf(t),n=i[a].value;n!==l&&(p(t),o(n))},d=e=>{let t=null;switch(e.key){case"Enter":m(e);break;case"ArrowRight":{const a=u.indexOf(e.currentTarget)+1;t=u[a]??u[0];break}case"ArrowLeft":{const a=u.indexOf(e.currentTarget)-1;t=u[a]??u[u.length-1];break}}t?.focus()};return r.createElement("ul",{role:"tablist","aria-orientation":"horizontal",className:(0,s.Z)("tabs",{"tabs--block":a},t)},i.map((e=>{let{value:t,label:a,attributes:o}=e;return r.createElement("li",(0,n.Z)({role:"tab",tabIndex:l===t?0:-1,"aria-selected":l===t,key:t,ref:e=>u.push(e),onKeyDown:d,onClick:m},o,{className:(0,s.Z)("tabs__item",w.tabItem,o?.className,{"tabs__item--active":l===t})}),a??t)})))}function E(e){let{lazy:t,children:a,selectedValue:n}=e;const l=(Array.isArray(a)?a:[a]).filter(Boolean);if(t){const e=l.find((e=>e.props.value===n));return e?(0,r.cloneElement)(e,{className:"margin-top--md"}):null}return r.createElement("div",{className:"margin-top--md"},l.map(((e,t)=>(0,r.cloneElement)(e,{key:t,hidden:e.props.value!==n}))))}function x(e){const t=v(e);return r.createElement("div",{className:(0,s.Z)("tabs-container",w.tabList)},r.createElement(N,(0,n.Z)({},e,t)),r.createElement(E,(0,n.Z)({},e,t)))}function T(e){const t=(0,y.Z)();return r.createElement(x,(0,n.Z)({key:String(t)},e))}var C={tabItem:"tabItem_Ymn6"};function I(e){let{children:t,hidden:a,className:n}=e;return r.createElement("div",{role:"tabpanel",className:(0,s.Z)(C.tabItem,n),hidden:a},t)}const O={},S=void 0,V={type:"mdx",permalink:"/katalog/",source:"@site/src/pages/index.mdx",description:"Why Katalog?",frontMatter:{}},j=[{value:"Why Katalog?",id:"why-katalog",level:2},{value:"Features of Katalog",id:"features-of-katalog",level:2},{value:"Extensions",id:"extensions",level:3},{value:"Sample App",id:"sample-app",level:2},{value:"Ideas",id:"ideas",level:2},{value:"References",id:"references",level:2}],P={toc:j},A="wrapper";function D(e){let{components:t,...a}=e;return(0,l.kt)(A,(0,n.Z)({},P,a,{components:t,mdxType:"MDXLayout"}),(0,l.kt)(u.default,{mdxType:"TopHeader"}),(0,l.kt)("h2",{id:"why-katalog"},"Why Katalog?"),(0,l.kt)("p",null,"Implementing UIs in the mobile app is becoming complex, and we need to be aware of visual omissions and degradation.\nKatalog is the UI catalog library that can manage, organize, and preview UI components inspired by ",(0,l.kt)("a",{parentName:"p",href:"https://storybook.js.org/"},"Storybook")," and ",(0,l.kt)("a",{parentName:"p",href:"https://github.com/playbook-ui/playbook-ios"},"Playbook"),"."),(0,l.kt)("p",null,"Katalog is enabled to build UIs independently from the domain/logic and it can easily play any UI state even hard-to-reach cases and edge cases.\nAlso, it is useful for facilitating UI components reuse by managing and previewing UIs."),(0,l.kt)("p",null,"Katalog will be a powerful driver of your development."),(0,l.kt)("h2",{id:"features-of-katalog"},"Features of Katalog"),(0,l.kt)(o.M,{imageUrl:(0,i.Z)("/img/docs/start.png"),width:1080,height:2280,mdxType:"Preview"},(0,l.kt)("p",null,"It is made with ",(0,l.kt)("inlineCode",{parentName:"p"},"Jetpack Compose")," and you can preview ",(0,l.kt)("inlineCode",{parentName:"p"},"Composable"),".\nYou can easily register and group UI components using the ",(0,l.kt)("inlineCode",{parentName:"p"},"DSL")," , as shown below."),(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-kotlin"},'class MyApplication : Application() {\n    override fun onCreate() {\n        super.onCreate()\n\n        registerKatalog(\n            title = "My App Catalog"\n        ) {\n            compose("UI Component") {\n                Text(text = "Hello, World")\n            }\n        }\n    }\n}\n'))),(0,l.kt)("p",null,"In addition to ",(0,l.kt)("a",{parentName:"p",href:"/docs/main/jetpack-compose"},"Composable"),", the following UI components are supported"),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"/docs/main/android-view"},"Android View")),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"/docs/main/binding"},"DataBinding / ViewBinding")),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"/docs/main/fragment"},"Fragment"))),(0,l.kt)(T,{mdxType:"Tabs"},(0,l.kt)(I,{value:"Android View",label:"Android View",default:!0,mdxType:"TabItem"},(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-kotlin"},'view(\n    name = "TextView"\n) {\n    TextView(context).apply {\n        text = "Hello, World"\n    }\n}\n'))),(0,l.kt)(I,{value:"DataBinding / ViewBinding",label:"DataBinding / ViewBinding",mdxType:"TabItem"},(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-kotlin"},'binding(\n    factory = SampleBinding::inflate,\n    name = "Binding Sample"\n)\n'))),(0,l.kt)(I,{value:"Fragment",label:"Fragment",mdxType:"TabItem"},(0,l.kt)("pre",null,(0,l.kt)("code",{parentName:"pre",className:"language-kotlin"},"fragment {\n    SampleFragment()\n}\n")))),(0,l.kt)("h3",{id:"extensions"},"Extensions"),(0,l.kt)("p",null,"Katalog provides additional features as Extensions.\nCurrently, the following extensions are available."),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"/docs/main/extensions/compose-theme"},"Compose Theme")," (Change the Compose Theme)"),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"/docs/main/extensions/android-theme"},"Android Theme")," (Change the Android Theme)"),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"/docs/main/extensions/page-saver"},"Page Saver")," (Restore the previously opened page)")),(0,l.kt)("p",null,"You can create an Extension.\nPlease refer to ",(0,l.kt)("a",{parentName:"p",href:"/docs/main/extensions/create"},"this document")," for more information."),(0,l.kt)("h2",{id:"sample-app"},"Sample App"),(0,l.kt)("p",null,"Check out the sample app ",(0,l.kt)("a",{parentName:"p",href:"https://github.com/mori-atsushi/katalog/tree/main/samples/androidapp"},"here"),"."),(0,l.kt)("h2",{id:"ideas"},"Ideas"),(0,l.kt)("p",null,"We consider adding the following features:"),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},"Search function."),(0,l.kt)("li",{parentName:"ul"},"Combine with Screenshot Test."),(0,l.kt)("li",{parentName:"ul"},"Provide some Addons."),(0,l.kt)("li",{parentName:"ul"},"Support ",(0,l.kt)("a",{parentName:"li",href:"https://www.jetbrains.com/lp/compose-mpp"},"Compose Multiplatform"),".")),(0,l.kt)("p",null,"If you have any other ideas or problems, please let us know in ",(0,l.kt)("a",{parentName:"p",href:"https://github.com/mori-atsushi/katalog/issues"},"Issue"),"."),(0,l.kt)("h2",{id:"references"},"References"),(0,l.kt)("p",null,"This library is inspired by the following libraries:"),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"https://storybook.js.org/"},"Storybook")," - for web-frontend"),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"https://github.com/playbook-ui/playbook-ios"},"Playbook")," - for iOS"),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("a",{parentName:"li",href:"https://github.com/airbnb/Showkase"},"Showkase")," - for Jetpack Compose (Android)")))}D.isMDXComponent=!0},8003:function(e,t,a){a.r(t),a.d(t,{default:function(){return m}});var n,r,l=a(7294),o=a(6010),i=a(9960),u={headerContainer:"headerContainer_EMGD",headerTitle:"headerTitle_gALw",button:"button_mfCG"};function s(){return s=Object.assign?Object.assign.bind():function(e){for(var t=1;t<arguments.length;t++){var a=arguments[t];for(var n in a)Object.prototype.hasOwnProperty.call(a,n)&&(e[n]=a[n])}return e},s.apply(this,arguments)}var c=e=>{let{title:t,titleId:a,...o}=e;return l.createElement("svg",s({"data-name":"\\u30B0\\u30EB\\u30FC\\u30D7 2",xmlns:"http://www.w3.org/2000/svg",width:95.667,height:123,viewBox:"0 0 95.667 123","aria-labelledby":a},o),t?l.createElement("title",{id:a},t):null,n||(n=l.createElement("defs",null,l.createElement("clipPath",{id:"a"},l.createElement("path",{"data-name":"\\u9577\\u65B9\\u5F62 3",fill:"none",d:"M0 0h95.667v123H0z"})))),r||(r=l.createElement("g",{"data-name":"\\u30B0\\u30EB\\u30FC\\u30D7 1",clipPath:"url(#a)"},l.createElement("path",{"data-name":"\\u30D1\\u30B9 1",d:"M82 0H13.667A13.649 13.649 0 0 0 .068 13.667L0 123l47.833-20.5L95.667 123V13.667A13.707 13.707 0 0 0 82 0",fill:"#4aab79"}),l.createElement("path",{"data-name":"\\u30D1\\u30B9 2",d:"M35.918 75.788c0 7.8.678 8.566 7.633 8.82v2.206H17.258v-2.206c6.955-.254 7.634-1.017 7.634-8.82V34.4c0-7.718-.679-8.566-7.294-8.82v-2.207h25.614v2.206c-6.616.254-7.294 1.1-7.294 8.82v23.069l17.556-19.591c3.732-4.156 5.258-6.616 5.258-8.651 0-2.375-1.611-3.308-6.275-3.647v-2.206h23.408v2.206c-6.022.508-10.179 3.307-18.235 12.213l-8.4 9.16L67.892 76.3c3.647 5.768 6.447 7.972 10.516 8.4v2.121H60.6c-1.1-2.545-1.1-2.545-4.579-8.228L41.854 55.009l-5.936 6.7Z",fill:"#fff"}))))},p=a.p+"assets/images/header-img-a1b3b02d4a64b2535d6e9e12ff910c21.png";function m(){return l.createElement("header",null,l.createElement("div",{className:(0,o.Z)("row",u.headerContainer)},l.createElement("div",{className:(0,o.Z)("col col--6",u.headerTitle)},l.createElement(c,{width:"84px",height:"108px"}),l.createElement("h1",{className:"hero__title"},"Katalog"),l.createElement("p",{className:"hero__subtitle"},"A UI Catalog Library made with Jetpack Compose"),l.createElement(i.Z,{className:(0,o.Z)("button",u.button),to:"/docs/getting-started"},"Getting Started")),l.createElement("div",{className:"col col--6"},l.createElement("img",{src:p}))))}},5527:function(e,t,a){a.d(t,{M:function(){return i}});var n=a(7294),r="container_C_nq",l="code_cQ_k",o="img_ZTde";const i=e=>{let{children:t,imageUrl:a,width:i,height:u}=e;return n.createElement("div",{className:r},n.createElement("div",{className:l},t),n.createElement("img",{className:o,src:a,width:i,height:u,alt:"",loading:"lazy"}))}}}]);