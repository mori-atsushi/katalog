"use strict";(self.webpackChunkdocs=self.webpackChunkdocs||[]).push([[269],{3905:function(e,t,n){n.d(t,{Zo:function(){return p},kt:function(){return u}});var a=n(7294);function r(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function i(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function o(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?i(Object(n),!0).forEach((function(t){r(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):i(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function l(e,t){if(null==e)return{};var n,a,r=function(e,t){if(null==e)return{};var n,a,r={},i=Object.keys(e);for(a=0;a<i.length;a++)n=i[a],t.indexOf(n)>=0||(r[n]=e[n]);return r}(e,t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(e);for(a=0;a<i.length;a++)n=i[a],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(r[n]=e[n])}return r}var m=a.createContext({}),d=function(e){var t=a.useContext(m),n=t;return e&&(n="function"==typeof e?e(t):o(o({},t),e)),n},p=function(e){var t=d(e.components);return a.createElement(m.Provider,{value:t},e.children)},c={inlineCode:"code",wrapper:function(e){var t=e.children;return a.createElement(a.Fragment,{},t)}},s=a.forwardRef((function(e,t){var n=e.components,r=e.mdxType,i=e.originalType,m=e.parentName,p=l(e,["components","mdxType","originalType","parentName"]),s=d(n),u=r,g=s["".concat(m,".").concat(u)]||s[u]||c[u]||i;return n?a.createElement(g,o(o({ref:t},p),{},{components:n})):a.createElement(g,o({ref:t},p))}));function u(e,t){var n=arguments,r=t&&t.mdxType;if("string"==typeof e||r){var i=n.length,o=new Array(i);o[0]=s;var l={};for(var m in t)hasOwnProperty.call(t,m)&&(l[m]=t[m]);l.originalType=e,l.mdxType="string"==typeof e?e:r,o[1]=l;for(var d=2;d<i;d++)o[d]=n[d];return a.createElement.apply(null,o)}return a.createElement.apply(null,n)}s.displayName="MDXCreateElement"},5527:function(e,t,n){n.d(t,{M:function(){return l}});var a=n(7294),r="container_3Maz",i="code_1u2W",o="img_34ER",l=function(e){var t=e.children,n=e.imageUrl,l=e.width,m=e.height;return a.createElement("div",{className:r},a.createElement("div",{className:i},t),a.createElement("img",{className:o,src:n,width:l,height:m,alt:"",loading:"lazy"}))}},7177:function(e,t,n){n.r(t),n.d(t,{frontMatter:function(){return m},contentTitle:function(){return d},metadata:function(){return p},toc:function(){return c},default:function(){return u}});var a=n(7462),r=n(3366),i=(n(7294),n(3905)),o=n(5527),l=["components"],m={sidebar_position:6},d="Fragment",p={unversionedId:"main/fragment",id:"main/fragment",isDocsHomePage:!1,title:"Fragment",description:"Setup",source:"@site/docs/main/fragment.mdx",sourceDirName:"main",slug:"/main/fragment",permalink:"/docs/main/fragment",editUrl:"https://github.com/cyberagent-zemi/katalog/edit/main/docs/docs/main/fragment.mdx",tags:[],version:"current",sidebarPosition:6,frontMatter:{sidebar_position:6},sidebar:"tutorialSidebar",previous:{title:"DataBinding / ViewBinding",permalink:"/docs/main/binding"},next:{title:"Compose Theme",permalink:"/docs/main/extensions/compose-theme"}},c=[{value:"Setup",id:"setup",children:[],level:2},{value:"Examples",id:"examples",children:[],level:2},{value:"Parameters",id:"parameters",children:[],level:2}],s={toc:c};function u(e){var t=e.components,n=(0,r.Z)(e,l);return(0,i.kt)("wrapper",(0,a.Z)({},s,n,{components:t,mdxType:"MDXLayout"}),(0,i.kt)("h1",{id:"fragment"},"Fragment"),(0,i.kt)("h2",{id:"setup"},"Setup"),(0,i.kt)("p",null,"Add the ",(0,i.kt)("inlineCode",{parentName:"p"},"katalog-android-view")," package."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-kotlin"},'dependencies {\n    implementation("co.jp.cyberagent.katalog:katalog-android:`LATEST_VERSION`")\n    implementation("co.jp.cyberagent.katalog:katalog-android-view:`LATEST_VERSION`")\n}\n')),(0,i.kt)("h2",{id:"examples"},"Examples"),(0,i.kt)(o.M,{imageUrl:"/img/docs/fragment.png",width:1080,height:2280,mdxType:"Preview"},(0,i.kt)("p",null,"To add a ",(0,i.kt)("inlineCode",{parentName:"p"},"Fragment"),", use the ",(0,i.kt)("inlineCode",{parentName:"p"},"fragment")," method.\nIf you omit the ",(0,i.kt)("inlineCode",{parentName:"p"},"name"),", the Fragment class name will be used."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-xml",metastring:'title="res/layout/fragment_sample.xml"',title:'"res/layout/fragment_sample.xml"'},'<?xml version="1.0" encoding="utf-8"?>\n<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"\n    android:layout_width="match_parent"\n    android:layout_height="match_parent">\n\n    <TextView\n        android:layout_gravity="center"\n        android:text="Hello, World"\n        android:layout_width="wrap_content"\n        android:layout_height="wrap_content" />\n\n</FrameLayout>\n')),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-kotlin"},"class SampleFragment : Fragment() {\n    override fun onCreateView(\n        inflater: LayoutInflater,\n        container: ViewGroup?,\n        savedInstanceState: Bundle?\n    ): View {\n        val binding = FragmentSampleBinding.inflate(inflater, container, false)\n        return binding.root\n    }\n}\n")),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-kotlin"},"fragment {\n    SampleFragment()\n}\n")),(0,i.kt)("p",null,"By default, ",(0,i.kt)("inlineCode",{parentName:"p"},"match_parent")," is used for both width and height.\nYou can change the size of the View by setting the ",(0,i.kt)("inlineCode",{parentName:"p"},"layoutParams"),".")),(0,i.kt)(o.M,{imageUrl:"/img/docs/fragment-update.png",width:1080,height:2280,mdxType:"Preview"},(0,i.kt)("p",null,"If you want to know when the View is created, use the ",(0,i.kt)("inlineCode",{parentName:"p"},"onCreateView")," parameter.\nYou can update the View safely."),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-xml",metastring:'title="res/layout/fragment_sample.xml"',title:'"res/layout/fragment_sample.xml"'},'<?xml version="1.0" encoding="utf-8"?>\n<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"\n    android:layout_width="match_parent"\n    android:layout_height="match_parent">\n\n    <TextView\n        android:id="@+id/text"\n        android:layout_gravity="center"\n        android:layout_width="wrap_content"\n        android:layout_height="wrap_content" />\n\n</FrameLayout>\n')),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-kotlin"},"class SampleFragment : Fragment() {\n    private var binding: FragmentSampleBinding? = null\n\n    override fun onCreateView(\n        inflater: LayoutInflater,\n        container: ViewGroup?,\n        savedInstanceState: Bundle?\n    ): View {\n        binding = FragmentSampleBinding.inflate(inflater, container, false)\n        return binding!!.root\n    }\n\n    fun updateText(value: String) {\n        binding!!.text.text = value\n    }\n\n    override fun onDestroyView() {\n        super.onDestroyView()\n        binding = null\n    }\n}\n")),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-kotlin"},'fragment(\n    onCreateView = { fragment ->\n        fragment.updateText("Updated!")\n    }\n) {\n    SampleFragment()\n}\n'))),(0,i.kt)("h2",{id:"parameters"},"Parameters"),(0,i.kt)("table",null,(0,i.kt)("thead",{parentName:"table"},(0,i.kt)("tr",{parentName:"thead"},(0,i.kt)("th",{parentName:"tr",align:"left"},"name"),(0,i.kt)("th",{parentName:"tr",align:"left"},"description"))),(0,i.kt)("tbody",{parentName:"table"},(0,i.kt)("tr",{parentName:"tbody"},(0,i.kt)("td",{parentName:"tr",align:"left"},"name"),(0,i.kt)("td",{parentName:"tr",align:"left"},"The UI Component name. If you omit this, the Fragment class name will be used.")),(0,i.kt)("tr",{parentName:"tbody"},(0,i.kt)("td",{parentName:"tr",align:"left"},"layoutParams"),(0,i.kt)("td",{parentName:"tr",align:"left"},"Specifies the size of the View. By default, ",(0,i.kt)("inlineCode",{parentName:"td"},"match_parent")," is used for both width and height.")),(0,i.kt)("tr",{parentName:"tbody"},(0,i.kt)("td",{parentName:"tr",align:"left"},"onCreateView"),(0,i.kt)("td",{parentName:"tr",align:"left"},"Called when the Fragment's View is created. This is a safe way to update the View. Inside the lambda expression, you can access ",(0,i.kt)("inlineCode",{parentName:"td"},"activity"),", ",(0,i.kt)("inlineCode",{parentName:"td"},"context"),", and ",(0,i.kt)("inlineCode",{parentName:"td"},"lifecycleOwner"),". This is optional.")),(0,i.kt)("tr",{parentName:"tbody"},(0,i.kt)("td",{parentName:"tr",align:"left"},"definition"),(0,i.kt)("td",{parentName:"tr",align:"left"},"Create a Fragment instance. Inside the lambda expression, you can access activity, context, and lifecycleOwner.")))))}u.isMDXComponent=!0}}]);