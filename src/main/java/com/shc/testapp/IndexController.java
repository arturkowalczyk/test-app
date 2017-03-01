package com.shc.testapp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * A controller for index page.
 *
 * @author created: akowalczyk on 2017-02-27 13:41
 * @author last change: $Author: $ on $Date: $
 * @version $Revision: $
 */
@Controller
public class IndexController
{

    public static final String MESSAGES = "messages";

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public ModelAndView index( ModelAndView mv, HttpSession session, @AuthenticationPrincipal User user )
    {
        if( session.getAttribute(MESSAGES) == null )
        {
            session.setAttribute(MESSAGES, new ArrayList< String >() );
        }

        mv.setViewName( "index" );
        mv.addObject( "user", user.getUsername() );

        return mv;
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public String postMessage( HttpSession session, @RequestParam( "message" ) String message )
    {
        final List< String > messages = (List< String >)session.getAttribute(MESSAGES);
        messages.add( message );

        return "redirect:/";
    }
}
