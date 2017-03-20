# Material_Design
### Material Design(材质设计)是Google在2014年I/O大会上发布的一种新的设计规范。支持5.0及以上的设备，兼容至2.1.
#### 准备工作
 添加相关依赖  :<br>
compile 'com.android.support:design:25.0.1'<br>
compile 'de.hdodenhof:circleimageview:2.1.0':轻松实现图片圆形化的功能<br> 
compile 'com.android.support:recyclerview-v7:25.0.1'<br>
compile 'com.android.support:cardview-v7:25.0.1'<br>
compile 'com.github.bumptech.glide:glide:3.7.0':超级强大的图片加载库(图片会进行压缩)，可用于加载本地图片，网络图片，gif，甚至是本地视频<br>
>相关<br>
简单使用TextInputLayout、Toolbar、DrawerLayout、NavigationView、FloatingActionButton、Snackbar、CoordinatorLayout、CardView、AppBarLayout、
SwipeRefreshLayout、CollapsingToolbarLayout、Recyclerview。
#### TextInputLayout <br>
![img](https://github.com/ljrRookie/Material_Design/blob/master/Material_Design/TextInputLayout.gif)<br>

#### DrawerLayout、ToolBar、NavigationView、FloatingActionButton 、Snackbar
###### DrawerLayout:
它是一个布局，允许放入两个直接子控件，第一个子控件是主屏幕中显示的内容，第二个子控件是滑动菜单中显示的内容。<br>
###### NavigationView:
需要准备两个东西：menu.xml(在NavigationView中显示具体的菜单项);headerLayout(在NavigationView中显示头部布局的)<br>
![img](https://github.com/ljrRookie/Material_Design/blob/master/Material_Design/GIF.gif)<br>

#### CoordinatorLayout
它是一个增强版的FrameLayout，可以监听其所有子控件的各种事件，然后帮助我们做出最为合理的响应。<br>
它还可以控制协调内容区和AppBarLayout的滚动<br>
      没使用的效果：                                      使用的效果：<br>
![img](http://upload-images.jianshu.io/upload_images/623504-eefc577f31d4d2c6.gif)         ................  ![img](http://upload-images.jianshu.io/upload_images/623504-4bb65d3ec110ce37.gif)                                             
#### CardView、RecyclerView、AppBarLayout、SwipeRefreshLayout
###### cardView：
可以让页面中的元素看起来像在卡片中一样，并且还能拥有圆角和投影。<br>
###### AppBarLayout:
在CoordinatorLayout布局中会出现控件遮挡控件的现象。AppBarLayout继承于LinearLayout，使用它可以让包含在其中的子控件能响应被标记了ScrollingViewBehavior的的滚动事件。<br>
使用方法：<br>
1.将toolbar嵌套到AppBarLa中<br>
2.在滚动控件中添加app:layout_behavior="@string/appbar_scrolling_view_behavior"属性。<br>
3.在toolbar中添加app:layout_scrollFlags="scroll|enterAlways|snap"属性可以实现toolbar随着滚动方向选择显示还是隐藏。<br>
       (1)scroll：当RecyclerView向上滚动时，Toolbar会跟着一起向上滚动并实现隐藏。<br>
       (2)enterAlways:当RecyclerView向下滚动时，Toolbar会跟着一起向下滚动并重新显示。<br>
       (3)snap：表示当Toolbar还没有完全隐藏或显示的时候，会自动判断显示还是隐藏。<br>
###### SwipeRefreshLayout：
在需要实现下拉刷新的控件放置到SwipeRefreshLayout中就能实现了。<br>
![img](https://github.com/ljrRookie/Material_Design/blob/master/Material_Design/GIF4.gif)<br>
## 可折叠式标题栏
#### CollapsingToolBarLayout：
