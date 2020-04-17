package org.apache.jsp.View.friend_002dfinder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Controller.RelationControl;
import Controller.LikeControl;
import Controller.CommentControl;
import Controller.UserControl;
import Controller.PostControl;
import Model.Comment;
import java.util.Collections;
import javax.swing.JOptionPane;
import Model.User;
import java.util.ArrayList;
import java.sql.Connection;
import Model.Post;

public final class newsfeed_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_remove_var_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_remove_var_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_remove_var_nobody.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"This is social network html5 template available in themeforest......\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Social Network, Social Media, Make Friends, Newsfeed, Profile Page\" />\n");
      out.write("        <meta name=\"robots\" content=\"index, follow\" />\n");
      out.write("        <title>News Feed | Check what your friends are doing</title>\n");
      out.write("\n");
      out.write("        <!-- Stylesheets\n");
      out.write("        ================================================= -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/mystyle.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/ionicons.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\" />\n");
      out.write("        <link href=\"css/emoji.css\" rel=\"stylesheet\">\n");
      out.write("        <!--Google Webfont-->\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,300italic,400italic,500,500italic,600,600italic,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <!--Favicon-->\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"images/fav.png\"/>\n");
      out.write("        <script src=\"js/myscript.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .ion-images\n");
      out.write("        {\n");
      out.write("            width: 17px;\n");
      out.write("            height: 22px;\n");
      out.write("            position: absolute;\n");
      out.write("            top: 14px;\n");
      out.write("            left: 28px;\n");
      out.write("        }\n");
      out.write("        .done\n");
      out.write("        {\n");
      out.write("            height: 29px;\n");
      out.write("            margin-top: 7px;\n");
      out.write("            margin-left: 7px;\n");
      out.write("        }\n");
      out.write("        .em-laughing\n");
      out.write("        {\n");
      out.write("            margin-right: 3px\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("            var request;\n");
      out.write("            function sendComment()\n");
      out.write("            {\n");
      out.write("                var comment = document.getElementById(\"comment\").value,\n");
      out.write("                    id = document.getElementById(\"id\").value;\n");
      out.write("                alert(comment);\n");
      out.write("                alert(id);\n");
      out.write("                var url = \"../../addComment?comment=\" + comment + \"&id=\" +  id;\n");
      out.write("                if (window.XMLHttpRequest) {\n");
      out.write("                    request = new XMLHttpRequest();\n");
      out.write("                } else if (window.ActiveXObject) {\n");
      out.write("                    request = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                try\n");
      out.write("                {\n");
      out.write("                    request.onreadystatechange = getInfo;\n");
      out.write("                    request.open(\"GET\", url, true);\n");
      out.write("                    request.send();\n");
      out.write("                } catch (e)\n");
      out.write("                {\n");
      out.write("                    alert(\"Unable to connect to server\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function getInfo() {\n");
      out.write("                if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                    var val = this.responseXML;\n");
      out.write("                    alert(val);\n");
      out.write("                    var res = val.getElementsByTagName(\"res\")[0].text;\n");
      out.write("                    alert(res);\n");
      out.write("                    //document.getElementById(\"amit\").innerHTML = val;\n");
      out.write("                    //alert(val);\n");
      out.write("                    if(res == \"1\"){\n");
      out.write("                        //document.getElementById(\"amit\").innerHTML = \"INVALID\";\n");
      out.write("                    } else {\n");
      out.write("                        document.getElementById(\"incom\").innerHTML = \"INVALID Comment\"\n");
      out.write("                        //location.replace(\"info.jsp\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- Header\n");
      out.write("        ================================================= -->\n");
      out.write("        <header id=\"header\">\n");
      out.write("            <nav class=\"navbar navbar-default navbar-fixed-top menu\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("\n");
      out.write("                    <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n");
      out.write("                            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                        </button>\n");
      out.write("                        <a class=\"navbar-brand\" href=\"index.html\"><img src=\"images/logo.png\" alt=\"logo\" /></a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right main-menu\">\n");
      out.write("                            <li class=\"dropdown\"><a href=\"index.html\">Home</a></li>\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Newsfeed <span><img src=\"images/down-arrow.png\" alt=\"\" /></span></a>\n");
      out.write("                                <ul class=\"dropdown-menu newsfeed-home\">\n");
      out.write("                                    <li><a href=\"newsfeed.html\">Newsfeed</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-people-nearby.html\">Poeple Nearly</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-friends.html\">My friends</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-messages.html\">Chatroom</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-images.html\">Images</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-videos.html\">Videos</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Timeline <span><img src=\"images/down-arrow.png\" alt=\"\" /></span></a>\n");
      out.write("                                <ul class=\"dropdown-menu login\">\n");
      out.write("                                    <li><a href=\"timeline.html\">Timeline</a></li>\n");
      out.write("                                    <li><a href=\"timeline-about.html\">Timeline About</a></li>\n");
      out.write("                                    <li><a href=\"timeline-album.html\">Timeline Album</a></li>\n");
      out.write("                                    <li><a href=\"timeline-friends.html\">Timeline Friends</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle pages\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">All Pages <span><img src=\"images/down-arrow.png\" alt=\"\" /></span></a>\n");
      out.write("                                <ul class=\"dropdown-menu page-list\">\n");
      out.write("                                    <li><a href=\"index.html\">Landing Page</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed.html\">Newsfeed</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-people-nearby.html\">Poeple Nearly</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-friends.html\">My friends</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-messages.html\">Chatroom</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-images.html\">Images</a></li>\n");
      out.write("                                    <li><a href=\"newsfeed-videos.html\">Videos</a></li>\n");
      out.write("                                    <li><a href=\"timeline.html\">Timeline</a></li>\n");
      out.write("                                    <li><a href=\"timeline-about.html\">Timeline About</a></li>\n");
      out.write("                                    <li><a href=\"timeline-album.html\">Timeline Album</a></li>\n");
      out.write("                                    <li><a href=\"timeline-friends.html\">Timeline Friends</a></li>\n");
      out.write("                                    <li><a href=\"contact.html\">Contact Us</a></li>\n");
      out.write("                                    \n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"dropdown\"><a href=\"contact.html\">Contact</a></li>\n");
      out.write("                            <li class=\"dropdown\"><a href=\"../../LogOut\">Log Out</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <form class=\"navbar-form navbar-right hidden-sm\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <i class=\"icon ion-android-search\"></i>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Search friends, photos, videos\">\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div><!-- /.navbar-collapse -->\n");
      out.write("                </div><!-- /.container -->\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <!--Header End-->\n");
      out.write("\n");
      out.write("        <div id=\"page-contents\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                    <!-- Newsfeed Common Side Bar Left\n");
      out.write("                    ================================================= -->\n");
      out.write("                    <div class=\"col-md-3 static\">\n");
      out.write("                        <div class=\"profile-card\">\n");
      out.write("                            <img src=\"images/users/user-1.jpg\" alt=\"user\" class=\"profile-photo\" />\n");
      out.write("                            <h5><a href=\"timeline.html\" class=\"text-white\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></h5>\n");
      out.write("                            <a href=\"#\" class=\"text-white\"><i class=\"ion ion-android-person-add\"></i> 1,299 followers</a>\n");
      out.write("                        </div><!--profile card ends-->\n");
      out.write("                        <ul class=\"nav-news-feed\">\n");
      out.write("                            <li><i class=\"icon ion-ios-paper\"></i><div><a href=\"newsfeed.html\">My Newsfeed</a></div></li>\n");
      out.write("                            <li><i class=\"icon ion-ios-people\"></i><div><a href=\"newsfeed-people-nearby.html\">People Nearby</a></div></li>\n");
      out.write("                            <li><i class=\"icon ion-ios-people-outline\"></i><div><a href=\"newsfeed-friends.html\">Friends</a></div></li>\n");
      out.write("                            <li><i class=\"icon ion-chatboxes\"></i><div><a href=\"newsfeed-messages.html\">Messages</a></div></li>\n");
      out.write("                            <li><i class=\"icon ion-images\"></i><div><a href=\"newsfeed-images.html\">Images</a></div></li>\n");
      out.write("                            <li><i class=\"icon ion-ios-videocam\"></i><div><a href=\"newsfeed-videos.html\">Videos</a></div></li>\n");
      out.write("                        </ul><!--news-feed links ends-->\n");
      out.write("                        <div id=\"chat-block\">\n");
      out.write("                            <div class=\"title\">Chat online</div>\n");
      out.write("                            <ul class=\"online-users list-inline\">\n");
      out.write("                                <li><a href=\"newsfeed-messages.html\" title=\"Linda Lohan\"><img src=\"images/users/user-2.jpg\" alt=\"user\" class=\"img-responsive profile-photo\" /><span class=\"online-dot\"></span></a></li>\n");
      out.write("                                <li><a href=\"newsfeed-messages.html\" title=\"Sophia Lee\"><img src=\"images/users/user-3.jpg\" alt=\"user\" class=\"img-responsive profile-photo\" /><span class=\"online-dot\"></span></a></li>\n");
      out.write("                                <li><a href=\"newsfeed-messages.html\" title=\"John Doe\"><img src=\"images/users/user-4.jpg\" alt=\"user\" class=\"img-responsive profile-photo\" /><span class=\"online-dot\"></span></a></li>\n");
      out.write("                                <li><a href=\"newsfeed-messages.html\" title=\"Alexis Clark\"><img src=\"images/users/user-5.jpg\" alt=\"user\" class=\"img-responsive profile-photo\" /><span class=\"online-dot\"></span></a></li>\n");
      out.write("                                <li><a href=\"newsfeed-messages.html\" title=\"James Carter\"><img src=\"images/users/user-6.jpg\" alt=\"user\" class=\"img-responsive profile-photo\" /><span class=\"online-dot\"></span></a></li>\n");
      out.write("                                <li><a href=\"newsfeed-messages.html\" title=\"Robert Cook\"><img src=\"images/users/user-7.jpg\" alt=\"user\" class=\"img-responsive profile-photo\" /><span class=\"online-dot\"></span></a></li>\n");
      out.write("                                <li><a href=\"newsfeed-messages.html\" title=\"Richard Bell\"><img src=\"images/users/user-8.jpg\" alt=\"user\" class=\"img-responsive profile-photo\" /><span class=\"online-dot\"></span></a></li>\n");
      out.write("                                <li><a href=\"newsfeed-messages.html\" title=\"Anna Young\"><img src=\"images/users/user-9.jpg\" alt=\"user\" class=\"img-responsive profile-photo\" /><span class=\"online-dot\"></span></a></li>\n");
      out.write("                                <li><a href=\"newsfeed-messages.html\" title=\"Julia Cox\"><img src=\"images/users/user-10.jpg\" alt=\"user\" class=\"img-responsive profile-photo\" /><span class=\"online-dot\"></span></a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div><!--chat block ends-->\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-7\">\n");
      out.write("\n");
      out.write("                        <!-- Post Create Box\n");
      out.write("                                     ================================================= -->\n");
      out.write("                        <form action=\"../../SharePost\" method=\"POST\">\n");
      out.write("                            <div class=\"create-post\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-md-7 col-sm-7\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <img src=\"images/users/user-1.jpg\" alt=\"\" class=\"profile-photo-md\" />\n");
      out.write("                                            <textarea name=\"texts\" id=\"exampleTextarea\" cols=\"30\" rows=\"1\" class=\"form-control\" placeholder=\"Write what you wish\"></textarea>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-5 col-sm-5\">\n");
      out.write("                                        <div class=\"tools\">\n");
      out.write("                                            <ul class=\"publishing-tools list-inline\">\n");
      out.write("                                                <li><i class=\"ion-compose\"></i></li>\n");
      out.write("                                                <li><a href=\"#\"><input type=\"file\" id=\"file\" name=\"image\" class=\"ion-images\" /></a></li>\n");
      out.write("                                                <li><a href=\"#\"><i class=\"ion-ios-videocam\"></i></a></li>\n");
      out.write("                                                <li><a href=\"#\"><i class=\"ion-map\"></i></a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                            <button id=\"button\" class=\"btn btn-primary pull-right\" >Publish</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div><!-- Post Create Box End-->\n");
      out.write("                        </form>\n");
      out.write("                        <!-- Post Content\n");
      out.write("                        ================================================= -->\n");
      out.write("                        ");

                            // AraayList of class (POST)
                            ArrayList<Post> posts = new ArrayList();
                            // AraayList of class (Comment)
                            ArrayList<Comment> comments = new ArrayList();
                            // AraayList of class (User)
                            ArrayList<User> friends = new ArrayList();
                        
      out.write("\n");
      out.write("                        <!-- Object of class User get from session Scope-->\n");
      out.write("                        ");
      Model.User user = null;
      synchronized (session) {
        user = (Model.User) _jspx_page_context.getAttribute("user", PageContext.SESSION_SCOPE);
        if (user == null){
          user = new Model.User();
          _jspx_page_context.setAttribute("user", user, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("                        <!-- scriptlet to write code java ->\n");
      out.write("                        ");

                            // Connection of Database
                            Connection connect = (Connection) application.getAttribute("Connect");
                            // Object of class (Control_DB)
                            PostControl postcontrol = new PostControl();
                            // Set connection Of Database
                            postcontrol.setConnection(connect);
                            // get All Posts of DataBase
                            posts = postcontrol.getPosts(user);
                            // Set ArrayList Posts in Attribute (POSTS) to use it in foreach (Taglib)
                            pageContext.setAttribute("POSTS", posts);
                        
      out.write("\n");
      out.write("                        <!-- Foreach to Display All Post (TAGLIB) -->\n");
      out.write("                        ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${POSTS}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_c_forEach_0.setVar("post");
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("                            <!-- Set Variable (JSTL TAGLB) -->\n");
            out.write("                            ");
            if (_jspx_meth_c_set_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write("  \n");
            out.write("                            <div class=\"post-content\">\n");
            out.write("                                <!-- If Condition (if no-image not display) (JSTL TAGLB) -->\n");
            out.write("                                ");
            if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write("\n");
            out.write("                                <div class=\"post-container\">\n");
            out.write("                                    <img src=\"images/users/user-5.jpg\" alt=\"user\" class=\"profile-photo-md pull-left\" />\n");
            out.write("                                    <div class=\"post-detail\">\n");
            out.write("                                        <div class=\"user-info\">\n");
            out.write("                                            <!-- Create Object of class User That Exist in Package Model (Standred Action) -->\n");
            out.write("                                            ");
            Model.User Userid = null;
            synchronized (_jspx_page_context) {
              Userid = (Model.User) _jspx_page_context.getAttribute("Userid", PageContext.PAGE_SCOPE);
              if (Userid == null){
                Userid = new Model.User();
                _jspx_page_context.setAttribute("Userid", Userid, PageContext.PAGE_SCOPE);
                out.write("\n");
                out.write("                                                <!-- Set value of  Property id -->\n");
                out.write("                                                ");
                org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("Userid"), "id", "${post.getIduser()}", _jspx_page_context, null);
                out.write("\n");
                out.write("                                            ");
              }
            }
            out.write("\n");
            out.write("                                            <!-- Create Object of Class Post That Exist in Package Model (Standred Action) -->\n");
            out.write("                                            ");
            Model.Post Postid = null;
            synchronized (_jspx_page_context) {
              Postid = (Model.Post) _jspx_page_context.getAttribute("Postid", PageContext.PAGE_SCOPE);
              if (Postid == null){
                Postid = new Model.Post();
                _jspx_page_context.setAttribute("Postid", Postid, PageContext.PAGE_SCOPE);
                out.write("\n");
                out.write("                                                <!-- Set value of  Property idpost -->\n");
                out.write("                                                ");
                org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("Postid"), "idpost", "${post.getIdpost()}", _jspx_page_context, null);
                out.write("\n");
                out.write("                                            ");
              }
            }
            out.write("\n");
            out.write("                                            <!-- Create Object of Class Comment That Exist in Package Model (Standred Action) -->\n");
            out.write("                                            ");
            Model.Comment comment = null;
            synchronized (_jspx_page_context) {
              comment = (Model.Comment) _jspx_page_context.getAttribute("comment", PageContext.PAGE_SCOPE);
              if (comment == null){
                comment = new Model.Comment();
                _jspx_page_context.setAttribute("comment", comment, PageContext.PAGE_SCOPE);
                out.write("\n");
                out.write("                                                <!-- Set value of  Property iduser -->\n");
                out.write("                                                ");
                org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("comment"), "iduser", "${post.getIduser()}", _jspx_page_context, null);
                out.write("\n");
                out.write("                                                <!-- Set value of  Property idpost -->\n");
                out.write("                                                ");
                org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("comment"), "idpost", "${post.getIdpost()}", _jspx_page_context, null);
                out.write("\n");
                out.write("                                            ");
              }
            }
            out.write("\n");
            out.write("                                            <!-- scriptlet to write code java -->\n");
            out.write("                                            ");

                                                UserControl usercontrol = new UserControl();
                                                usercontrol.setConnection(connect);
                                                // get UserName
                                                Userid = usercontrol.getUserName(Userid);
                                                CommentControl commentcontrol = new CommentControl();
                                                commentcontrol.setConnection(connect);
                                                // get comments of user
                                                comments = commentcontrol.getComments(Postid);
                                                // Set ArrayList comments in Attribute (COMMENTS) to use it in foreach (Taglib)
                                                pageContext.setAttribute("COMMENTS", comments);
                                                LikeControl likecontrol = new LikeControl();
                                                likecontrol.setConnection(connect);
                                            
            out.write("\n");
            out.write("                                            <h5><a href=\"timeline.html\" class=\"profile-link\">\n");
            out.write("                                                    <!-- Display user Name-->\n");
            out.write("                                                    ");
            out.print( Userid.getName());
            out.write("\n");
            out.write("                                                </a> <span class=\"following\">following</span></h5>\n");
            out.write("                                            <p class=\"text-muted\">Published a photo about 3 mins ago</p>\n");
            out.write("                                        </div>\n");
            out.write("                                        <div class=\"reaction\">\n");
            out.write("                                            <a href=\"../../addLike?id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${post.getIdpost()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" class=\"btn text-green\"><i class=\"icon ion-thumbsup\"></i> ");
            out.print(likecontrol.numberLikes(Postid));
            out.write("</a>\n");
            out.write("                                        </div>\n");
            out.write("                                        <div class=\"line-divider\"></div>\n");
            out.write("                                        <div class=\"post-text\">\n");
            out.write("                                            <!-- Set Variable (JSTL TAGLB) -->\n");
            out.write("                                            ");
            if (_jspx_meth_c_set_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write(" \n");
            out.write("                                            <!-- If Condition (if no-text not display) (JSTL TAGLB) -->\n");
            out.write("                                            ");
            if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write("  \n");
            out.write("\n");
            out.write("                                        </div>\n");
            out.write("                                        <div class=\"line-divider\"></div>\n");
            out.write("                                        <!-- Foreach to Display All COMMENTS of Post (TAGLIB) -->\n");
            out.write("                                        ");
            //  c:forEach
            org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
            _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
            _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
            _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${COMMENTS}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
            _jspx_th_c_forEach_1.setVar("com");
            int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
            try {
              int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
              if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\n");
                  out.write("                                            <!-- Create Object of class User That Exist in Package Model (Standred Action) -->\n");
                  out.write("                                            ");
                  Model.User usercomment = null;
                  synchronized (_jspx_page_context) {
                    usercomment = (Model.User) _jspx_page_context.getAttribute("usercomment", PageContext.PAGE_SCOPE);
                    if (usercomment == null){
                      usercomment = new Model.User();
                      _jspx_page_context.setAttribute("usercomment", usercomment, PageContext.PAGE_SCOPE);
                      out.write("\n");
                      out.write("                                                <!-- Set value of  Property id -->\n");
                      out.write("                                                ");
                      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetPropertyExpression(_jspx_page_context.findAttribute("usercomment"), "id", "${com.getIduser()}", _jspx_page_context, null);
                      out.write("\n");
                      out.write("                                            ");
                    }
                  }
                  out.write("\n");
                  out.write("                                            <!-- scriptlet to write code java -->\n");
                  out.write("                                            ");

                                                usercomment = usercontrol.getUserName(usercomment);
                                            
                  out.write("\n");
                  out.write("                                            <div class=\"post-comment\">\n");
                  out.write("                                                <img src=\"images/users/user-11.jpg\" alt=\"\" class=\"profile-photo-sm\" />\n");
                  out.write("                                                <p><a href=\"timeline.html\" class=\"profile-link\">");
                  out.print(usercomment.getName());
                  out.write(" </a><i class=\"em em-laughing\"></i>\n");
                  out.write("                                                    <!-- Display Comment of Post-->\n");
                  out.write("                                                    ");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${com.getComment()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                  out.write("\n");
                  out.write("                                                </p>\n");
                  out.write("                                            </div>\n");
                  out.write("                                            <!--Remove Objects (JSTL TAGLB) -->   \n");
                  out.write("                                            ");
                  if (_jspx_meth_c_remove_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
                    return;
                  out.write("\n");
                  out.write("                                        ");
                  int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_c_forEach_1.doCatch(_jspx_exception);
            } finally {
              _jspx_th_c_forEach_1.doFinally();
              _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
            }
            out.write("\n");
            out.write("                                            <div id=\"incom\"></div>\n");
            out.write("                                        <form>\n");
            out.write("                                            <div class=\"post-comment\">\n");
            out.write("                                                <img src=\"images/users/user-1.jpg\" alt=\"\" class=\"profile-photo-sm\" />\n");
            out.write("                                                <input type=\"text\" id=\"comment\" class=\"form-control\" placeholder=\"Post a comment\" />\n");
            out.write("                                                <input id=\"id\" type=\"hidden\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${post.getIdpost()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" />\n");
            out.write("                                                <input class=\"done\" type=\"submit\" onclick=\"sendComment()\" value=\"done\" />\n");
            out.write("                                            </div>\n");
            out.write("                                        </form>\n");
            out.write("                                    </div>\n");
            out.write("                                </div>\n");
            out.write("                            </div>\n");
            out.write("                            <!-- Remove Objects (JSTL TAGLB) \n");
            out.write("                            ========================================================-->\n");
            out.write("                            ");
            if (_jspx_meth_c_remove_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write("\n");
            out.write("                            ");
            if (_jspx_meth_c_remove_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write("\n");
            out.write("                            ");
            if (_jspx_meth_c_remove_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
              return;
            out.write("\n");
            out.write("                        ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\n");
      out.write("\n");
      out.write("                        <!-- Newsfeed Common Side Bar Right\n");
      out.write("                        ================================================= -->\n");
      out.write("                        <!-- scriptlet to write code java -->\n");
      out.write("                        ");

                            RelationControl relationcontrol = new RelationControl();
                            relationcontrol.setConnection(connect);
                            friends = relationcontrol.getFriends(user);
                            pageContext.setAttribute("FRINDS", friends);
                            
      out.write("\n");
      out.write("                        <!-- Foreach to Display All friends of Post (TAGLIB) -->\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Footer\n");
      out.write("            ================================================= -->\n");
      out.write("            <footer id=\"footer\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"footer-wrapper\">\n");
      out.write("                            <div class=\"col-md-3 col-sm-3\">\n");
      out.write("                                <a href=\"\"><img src=\"images/logo-black.png\" alt=\"\" class=\"footer-logo\" /></a>\n");
      out.write("                                <ul class=\"list-inline social-icons\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"icon ion-social-facebook\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"icon ion-social-twitter\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"icon ion-social-googleplus\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"icon ion-social-pinterest\"></i></a></li>\n");
      out.write("                                    <li><a href=\"#\"><i class=\"icon ion-social-linkedin\"></i></a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 col-sm-2\">\n");
      out.write("                                <h6>For individuals</h6>\n");
      out.write("                                <ul class=\"footer-links\">\n");
      out.write("                                    <li><a href=\"\">Signup</a></li>\n");
      out.write("                                    <li><a href=\"\">login</a></li>\n");
      out.write("                                    <li><a href=\"\">Explore</a></li>\n");
      out.write("                                    <li><a href=\"\">Finder app</a></li>\n");
      out.write("                                    <li><a href=\"\">Features</a></li>\n");
      out.write("                                    <li><a href=\"\">Language settings</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 col-sm-2\">\n");
      out.write("                                <h6>For businesses</h6>\n");
      out.write("                                <ul class=\"footer-links\">\n");
      out.write("                                    <li><a href=\"\">Business signup</a></li>\n");
      out.write("                                    <li><a href=\"\">Business login</a></li>\n");
      out.write("                                    <li><a href=\"\">Benefits</a></li>\n");
      out.write("                                    <li><a href=\"\">Resources</a></li>\n");
      out.write("                                    <li><a href=\"\">Advertise</a></li>\n");
      out.write("                                    <li><a href=\"\">Setup</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2 col-sm-2\">\n");
      out.write("                                <h6>About</h6>\n");
      out.write("                                <ul class=\"footer-links\">\n");
      out.write("                                    <li><a href=\"\">About us</a></li>\n");
      out.write("                                    <li><a href=\"\">Contact us</a></li>\n");
      out.write("                                    <li><a href=\"\">Privacy Policy</a></li>\n");
      out.write("                                    <li><a href=\"\">Terms</a></li>\n");
      out.write("                                    <li><a href=\"\">Help</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-3 col-sm-3\">\n");
      out.write("                                <h6>Contact Us</h6>\n");
      out.write("                                <ul class=\"contact\">\n");
      out.write("                                    <li><i class=\"icon ion-ios-telephone-outline\"></i>+1 (234) 222 0754</li>\n");
      out.write("                                    <li><i class=\"icon ion-ios-email-outline\"></i>info@thunder-team.com</li>\n");
      out.write("                                    <li><i class=\"icon ion-ios-location-outline\"></i>228 Park Ave S NY, USA</li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"copyright\">\n");
      out.write("                    <p>Thunder Team © 2016. All rights reserved</p>\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("            <!--preloader-->\n");
      out.write("            <div id=\"spinner-wrapper\">\n");
      out.write("                <div class=\"spinner\"></div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Scripts\n");
      out.write("            ================================================= -->\n");
      out.write("            <script src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("            <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("            <script src=\"js/jquery.sticky-kit.min.js\"></script>\n");
      out.write("            <script src=\"js/jquery.scrollbar.min.js\"></script>\n");
      out.write("            <script src=\"js/script.js\"></script>\n");
      out.write("\n");
      out.write("            <script async defer src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCTMXfmDn0VlqWIyoOxK8997L-amWbUPiQ&callback=initMap\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_0.setVar("image");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${post.getImage()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${image != ''}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("  \n");
        out.write("                                    <img src=\"images/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${post.getImage()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" alt=\"post-image\" class=\"img-responsive post-image\" />\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_1.setVar("text");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${post.getText()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${text != ''}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("  \n");
        out.write("                                                <p>\n");
        out.write("                                                    ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${post.getText()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                                                </p>\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_remove_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_0.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_remove_0.setVar("usercomment");
    int _jspx_eval_c_remove_0 = _jspx_th_c_remove_0.doStartTag();
    if (_jspx_th_c_remove_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_0);
      return true;
    }
    _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_0);
    return false;
  }

  private boolean _jspx_meth_c_remove_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_1 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_1.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_remove_1.setVar("Userid");
    int _jspx_eval_c_remove_1 = _jspx_th_c_remove_1.doStartTag();
    if (_jspx_th_c_remove_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_1);
      return true;
    }
    _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_1);
    return false;
  }

  private boolean _jspx_meth_c_remove_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_2 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_2.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_remove_2.setVar("Postid");
    int _jspx_eval_c_remove_2 = _jspx_th_c_remove_2.doStartTag();
    if (_jspx_th_c_remove_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_2);
      return true;
    }
    _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_2);
    return false;
  }

  private boolean _jspx_meth_c_remove_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_3 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_3.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_remove_3.setVar("usercomment");
    int _jspx_eval_c_remove_3 = _jspx_th_c_remove_3.doStartTag();
    if (_jspx_th_c_remove_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_3);
      return true;
    }
    _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_3);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${FRINDS}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("friend");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <div class=\"col-md-4\">\n");
          out.write("                                <div class=\"suggestions\" id=\"sticky-sidebar\">\n");
          out.write("                                    <h4 class=\"grey\">Who to Follow</h4>\n");
          out.write("                                    <div class=\"follow-user\">\n");
          out.write("                                        <img src=\"images/users/user-11.jpg\" alt=\"\" class=\"profile-photo-sm pull-left\" />\n");
          out.write("                                        <div>\n");
          out.write("                                            <!-- Display Name of Friend -->\n");
          out.write("                                            <h5><a href=\"timeline.html\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friend.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h5>\n");
          out.write("                                            <a href=\"../../addfriend?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${friend.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"text-green\">Add friend</a>\n");
          out.write("                                        </div>\n");
          out.write("                                    </div>\n");
          out.write("                                </div>\n");
          out.write("                            </div>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
