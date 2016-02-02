package com.camel.resources

import org.springframework.util.Assert;

public class CamelUtils {

    public static String buildJmsEndpoint(String endpoint, String... options) {
        Assert.hasLength(endpoint);
        Assert.state(endpoint.startsWith("T") || endpoint.startsWith("Q"),
                "Jms In endpoint must start with a T or a Q.");

        StringBuilder builder = new StringBuilder().append("jms:");

        if (endpoint.startsWith("T")) {
            builder.append("topic:");
        } else {
            builder.append("queue:");
        }

        builder.append(endpoint);

        if (options != null && options.length > 0) {
            builder.append("?");

            for (int i = 0; i < options.length; i++) {
                if (i != 0 )
                    builder.append("&");
                builder.append(options[i]);
            }
        }

        return builder.toString();
    }
    
    public static String buildEmailEndpoint(String endpoint, String... options) {
      Assert.hasLength(endpoint);
    
      StringBuilder builder = new StringBuilder().append("smtp://");
      builder.append(endpoint);
     

      if (options != null && options.length > 0) {
          builder.append("?");

          for (int i = 0; i < options.length; i++) {
                if (i != 0 )
                  builder.append("&");
              builder.append(options[i]);
          }
      }

      return builder.toString();
  }
    
    public static String buildFileEndpoint(String endpoint, String... options) {
      Assert.hasLength(endpoint);
    
      StringBuilder builder = new StringBuilder().append("file://");
      builder.append(endpoint);
     

      if (options != null && options.length > 0) {
          builder.append("?");

          for (int i = 0; i < options.length; i++) {
              if (i != 0 )
                  builder.append("&");
              builder.append(options[i]);
          }
      }

      return builder.toString();
  }
    
    public static String buildQuartzEndpoint(String endpoint, String... options) {
      Assert.hasLength(endpoint);
    
      StringBuilder builder = new StringBuilder().append("quartz://");
      builder.append(endpoint);
     

      if (options != null && options.length > 0) {
          builder.append("?");

          for (int i = 0; i < options.length; i++) {
              if (i != 0 )
                  builder.append("&");
              builder.append(options[i]);
          }
      }

      return builder.toString();
  }
}
