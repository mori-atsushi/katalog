"use strict";(self.webpackChunkdocs=self.webpackChunkdocs||[]).push([[727],{3905:function(e,n,t){t.d(n,{Zo:function(){return p},kt:function(){return u}});var a=t(7294);function i(e,n,t){return n in e?Object.defineProperty(e,n,{value:t,enumerable:!0,configurable:!0,writable:!0}):e[n]=t,e}function r(e,n){var t=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);n&&(a=a.filter((function(n){return Object.getOwnPropertyDescriptor(e,n).enumerable}))),t.push.apply(t,a)}return t}function l(e){for(var n=1;n<arguments.length;n++){var t=null!=arguments[n]?arguments[n]:{};n%2?r(Object(t),!0).forEach((function(n){i(e,n,t[n])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(t)):r(Object(t)).forEach((function(n){Object.defineProperty(e,n,Object.getOwnPropertyDescriptor(t,n))}))}return e}function o(e,n){if(null==e)return{};var t,a,i=function(e,n){if(null==e)return{};var t,a,i={},r=Object.keys(e);for(a=0;a<r.length;a++)t=r[a],n.indexOf(t)>=0||(i[t]=e[t]);return i}(e,n);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(a=0;a<r.length;a++)t=r[a],n.indexOf(t)>=0||Object.prototype.propertyIsEnumerable.call(e,t)&&(i[t]=e[t])}return i}var d=a.createContext({}),m=function(e){var n=a.useContext(d),t=n;return e&&(t="function"==typeof e?e(n):l(l({},n),e)),t},p=function(e){var n=m(e.components);return a.createElement(d.Provider,{value:n},e.children)},c={inlineCode:"code",wrapper:function(e){var n=e.children;return a.createElement(a.Fragment,{},n)}},s=a.forwardRef((function(e,n){var t=e.components,i=e.mdxType,r=e.originalType,d=e.parentName,p=o(e,["components","mdxType","originalType","parentName"]),s=m(t),u=i,g=s["".concat(d,".").concat(u)]||s[u]||c[u]||r;return t?a.createElement(g,l(l({ref:n},p),{},{components:t})):a.createElement(g,l({ref:n},p))}));function u(e,n){var t=arguments,i=n&&n.mdxType;if("string"==typeof e||i){var r=t.length,l=new Array(r);l[0]=s;var o={};for(var d in n)hasOwnProperty.call(n,d)&&(o[d]=n[d]);o.originalType=e,o.mdxType="string"==typeof e?e:i,l[1]=o;for(var m=2;m<r;m++)l[m]=t[m];return a.createElement.apply(null,l)}return a.createElement.apply(null,t)}s.displayName="MDXCreateElement"},5527:function(e,n,t){t.d(n,{M:function(){return o}});var a=t(7294),i="container_3Maz",r="code_1u2W",l="img_34ER",o=function(e){var n=e.children,t=e.imageUrl,o=e.width,d=e.height;return a.createElement("div",{className:i},a.createElement("div",{className:r},n),a.createElement("img",{className:l,src:t,width:o,height:d,alt:"",loading:"lazy"}))}},3325:function(e,n,t){t.r(n),t.d(n,{frontMatter:function(){return d},contentTitle:function(){return m},metadata:function(){return p},toc:function(){return c},default:function(){return u}});var a=t(7462),i=t(3366),r=(t(7294),t(3905)),l=t(5527),o=["components"],d={sidebar_position:5},m="DataBinding / ViewBinding",p={unversionedId:"main/binding",id:"main/binding",isDocsHomePage:!1,title:"DataBinding / ViewBinding",description:"Setup",source:"@site/docs/main/binding.mdx",sourceDirName:"main",slug:"/main/binding",permalink:"/docs/main/binding",editUrl:"https://github.com/cyberagent-zemi/katalog/edit/main/docs/docs/main/binding.mdx",tags:[],version:"current",sidebarPosition:5,frontMatter:{sidebar_position:5},sidebar:"tutorialSidebar",previous:{title:"Android View",permalink:"/docs/main/android-view"},next:{title:"Fragment",permalink:"/docs/main/fragment"}},c=[{value:"Setup",id:"setup",children:[],level:2},{value:"Examples",id:"examples",children:[],level:2},{value:"Parameters",id:"parameters",children:[],level:2}],s={toc:c};function u(e){var n=e.components,t=(0,i.Z)(e,o);return(0,r.kt)("wrapper",(0,a.Z)({},s,t,{components:n,mdxType:"MDXLayout"}),(0,r.kt)("h1",{id:"databinding--viewbinding"},"DataBinding / ViewBinding"),(0,r.kt)("h2",{id:"setup"},"Setup"),(0,r.kt)("p",null,"Add the ",(0,r.kt)("inlineCode",{parentName:"p"},"katalog-androidview")," package."),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-kotlin"},'dependencies {\n    implementation("jp.co.cyberagent.katalog:katalog:`LATEST_VERSION`")\n    implementation("jp.co.cyberagent.katalog:katalog-androidview:`LATEST_VERSION`")\n}\n')),(0,r.kt)("h2",{id:"examples"},"Examples"),(0,r.kt)(l.M,{imageUrl:"/img/docs/binding.png",width:1080,height:2280,mdxType:"Preview"},(0,r.kt)("p",null,"To add a ",(0,r.kt)("inlineCode",{parentName:"p"},"DataBinding")," / ",(0,r.kt)("inlineCode",{parentName:"p"},"ViewBinding"),", use the ",(0,r.kt)("inlineCode",{parentName:"p"},"binding")," method.\nPass an ",(0,r.kt)("inlineCode",{parentName:"p"},"inflate")," method reference to the ",(0,r.kt)("inlineCode",{parentName:"p"},"factory")," parameter.\nIf you omit the ",(0,r.kt)("inlineCode",{parentName:"p"},"name"),", the Binding class name will be used."),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-xml",metastring:'title="res/layout/sample.xml"',title:'"res/layout/sample.xml"'},'<?xml version="1.0" encoding="utf-8"?>\n<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"\n    android:layout_width="match_parent"\n    android:layout_height="match_parent">\n\n    <TextView\n        android:layout_gravity="center"\n        android:text="Hello, World"\n        android:layout_width="wrap_content"\n        android:layout_height="wrap_content" />\n\n</FrameLayout>\n')),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-kotlin"},'binding(\n    factory = SampleBinding::inflate,\n    name = "Binding Sample"\n)\n'))),(0,r.kt)(l.M,{imageUrl:"/img/docs/binding-match.png",width:1080,height:2280,mdxType:"Preview"},(0,r.kt)("p",null,"By default, ",(0,r.kt)("inlineCode",{parentName:"p"},"wrap_content")," is used for both width and height.\nYou can change the size of the View by setting the ",(0,r.kt)("inlineCode",{parentName:"p"},"layoutParams"),"."),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-xml",metastring:'title="res/layout/sample.xml"',title:'"res/layout/sample.xml"'},'<?xml version="1.0" encoding="utf-8"?>\n<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"\n    android:background="#FF0000"\n    android:layout_width="match_parent"\n    android:layout_height="match_parent">\n\n    <TextView\n        android:layout_gravity="center"\n        android:text="Hello, World"\n        android:layout_width="wrap_content"\n        android:layout_height="wrap_content" />\n</FrameLayout>\n')),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-kotlin"},'binding(\n    factory = SampleBinding::inflate,\n    name = "Binding Sample",\n    layoutParams = MATCH_WIDTH_WRAP_HEIGHT\n)\n')),(0,r.kt)("p",null,"The following four options are available."),(0,r.kt)("ul",null,(0,r.kt)("li",{parentName:"ul"},(0,r.kt)("inlineCode",{parentName:"li"},"WARP_WIDTH_WRAP_HEIGHT")," - It is default."),(0,r.kt)("li",{parentName:"ul"},(0,r.kt)("inlineCode",{parentName:"li"},"MATCH_WIDTH_WRAP_HEIGHT")),(0,r.kt)("li",{parentName:"ul"},(0,r.kt)("inlineCode",{parentName:"li"},"WRAP_WIDTH_WRAP_HEIGHT")),(0,r.kt)("li",{parentName:"ul"},(0,r.kt)("inlineCode",{parentName:"li"},"MATCH_WIDTH_MATCH_HEIGHT")))),(0,r.kt)(l.M,{imageUrl:"/img/docs/binding-size.png",width:1080,height:2280,mdxType:"Preview"},(0,r.kt)("p",null,"You can also specify a number directly.\nNote that the value is in pixels."),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-xml",metastring:'title="res/layout/sample.xml"',title:'"res/layout/sample.xml"'},'<?xml version="1.0" encoding="utf-8"?>\n<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"\n    android:background="#FF0000"\n    android:layout_width="match_parent"\n    android:layout_height="match_parent">\n\n    <TextView\n        android:layout_gravity="center"\n        android:text="Hello, World"\n        android:layout_width="wrap_content"\n        android:layout_height="wrap_content" />\n</FrameLayout>\n')),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-kotlin"},'binding(\n    factory = SampleBinding::inflate,\n    name = "Binding Sample",\n    layoutParams = ViewGroup.LayoutParams(600, 300)\n)\n'))),(0,r.kt)(l.M,{imageUrl:"/img/docs/binding.png",width:1080,height:2280,mdxType:"Preview"},(0,r.kt)("p",null,"The Binding parameters can be set in the lambda expression."),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-xml",metastring:'title="res/layout/sample.xml"',title:'"res/layout/sample.xml"'},'<?xml version="1.0" encoding="utf-8"?>\n<layout xmlns:android="http://schemas.android.com/apk/res/android">\n\n    <data>\n\n        <variable\n            name="text"\n            type="String" />\n    </data>\n\n    <FrameLayout\n        android:layout_width="match_parent"\n        android:layout_height="match_parent">\n\n        <TextView\n            android:layout_gravity="center"\n            android:text="@{text}"\n            android:layout_width="wrap_content"\n            android:layout_height="wrap_content" />\n    </FrameLayout>\n</layout>\n')),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-kotlin"},'binding(\n    factory = SampleBinding::inflate,\n    name = "Binding Sample"\n) { binding ->\n    binding.text = "Hello, World"\n}\n'))),(0,r.kt)(l.M,{imageUrl:"/img/docs/android-view-livedata.gif",width:1080,height:2280,mdxType:"Preview"},(0,r.kt)("p",null,"It is also possible to use ",(0,r.kt)("inlineCode",{parentName:"p"},"LiveData")," and ",(0,r.kt)("inlineCode",{parentName:"p"},"StateFlow")," in ",(0,r.kt)("inlineCode",{parentName:"p"},"DataBinding"),".\nDon't forget to pass the ",(0,r.kt)("inlineCode",{parentName:"p"},"LifecycleOwner")," to the Binding class."),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-kotlin",metastring:'title="SampleViewModel.kt"',title:'"SampleViewModel.kt"'},"class SampleViewModel {\n    private val _count = MutableLiveData(0)\n    val count: LiveData<Int> = _count\n\n    fun handleClick() {\n        _count.value = (_count.value!! + 1) % 10\n    }\n}\n")),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-xml",metastring:'title="res/layout/sample.xml"',title:'"res/layout/sample.xml"'},'<?xml version="1.0" encoding="utf-8"?>\n<layout xmlns:android="http://schemas.android.com/apk/res/android">\n\n    <data>\n\n        <variable\n            name="viewModel"\n            type="jp.co.cyberagent.katalog.android_sample.SampleViewModel" />\n    </data>\n\n    <FrameLayout\n        android:layout_width="match_parent"\n        android:layout_height="match_parent">\n\n        <TextView\n            android:onClick="@{() -> viewModel.handleClick()}"\n            android:layout_gravity="center"\n            android:text="@{viewModel.count.toString()}"\n            android:layout_width="wrap_content"\n            android:layout_height="wrap_content" />\n    </FrameLayout>\n</layout>\n')),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-kotlin"},'binding(\n    factory = SampleBinding::inflate,\n    name = "Counter"\n) { binding ->\n    binding.viewModel = SampleViewModel()\n    binding.lifecycleOwner = lifecycleOwner\n}\n'))),(0,r.kt)("h2",{id:"parameters"},"Parameters"),(0,r.kt)("table",null,(0,r.kt)("thead",{parentName:"table"},(0,r.kt)("tr",{parentName:"thead"},(0,r.kt)("th",{parentName:"tr",align:"left"},"name"),(0,r.kt)("th",{parentName:"tr",align:"left"},"description"))),(0,r.kt)("tbody",{parentName:"table"},(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:"left"},"factory"),(0,r.kt)("td",{parentName:"tr",align:"left"},"Passes a reference to the Binding's inflation method.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:"left"},"name"),(0,r.kt)("td",{parentName:"tr",align:"left"},"The UI Component name. If you omit this, the Binding class name will be used.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:"left"},"layoutParams"),(0,r.kt)("td",{parentName:"tr",align:"left"},"Specifies the size of the View. By default, ",(0,r.kt)("inlineCode",{parentName:"td"},"wrap_content")," is used for both width and height.")),(0,r.kt)("tr",{parentName:"tbody"},(0,r.kt)("td",{parentName:"tr",align:"left"},"update"),(0,r.kt)("td",{parentName:"tr",align:"left"},"Set the Binding parameters. Inside the lambda expression, you can access ",(0,r.kt)("inlineCode",{parentName:"td"},"activity"),", ",(0,r.kt)("inlineCode",{parentName:"td"},"context"),", and ",(0,r.kt)("inlineCode",{parentName:"td"},"lifecycleOwner"),". This is optional.")))))}u.isMDXComponent=!0}}]);