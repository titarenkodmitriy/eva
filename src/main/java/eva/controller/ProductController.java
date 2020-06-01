package eva.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import eva.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    IProductService service;

    @GetMapping("/product")
    public void getProduct(@RequestParam(value = "nameFilter") String filter, HttpServletResponse resp)
            throws Exception {
System.out.println("Filter is " + filter);
        resp.setContentType("application/json; charset=utf-8");
        Pattern pattern = Pattern.compile(filter);

        JsonFactory factory = new JsonFactory();
        final PrintWriter writer = resp.getWriter();
        JsonGenerator generator = factory.createGenerator(writer);

        generator.writeStartArray();

        service.getAllProductAsStream()
                .filter(e->
                    {
                        Matcher matcher = pattern.matcher(e.getName());
                        return matcher.find();
                    })
                .forEach( e->{
                    try {
                        generator.writeStartObject();
                        generator.writeNumberField("id", e.getId());
                        generator.writeStringField("name", e.getName());
                        generator.writeStringField("description", e.getDescription());
                        generator.writeEndObject();
                        generator.flush();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
        generator.writeEndArray();
        generator.close();
        writer.flush();
        writer.close();
    }
}
