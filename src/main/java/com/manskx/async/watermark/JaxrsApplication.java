package com.manskx.async.watermark;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Component
@ApplicationPath("/watermark/")
public class JaxrsApplication extends Application {

}