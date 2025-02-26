package fr.dawan.projet1.ws;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Priority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

//permet d intercepter la déserialisation par jaxrs
//voir aussi MessageBodyWriter/Reader
@Provider
@Priority(1000)
public class MyReaderInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		InputStream is = context.getInputStream();
		byte[] bytes = new byte[is.available()];
		is.read(bytes);
		String respContent = new String(bytes);
		respContent += "\n response modifiée dans l intercepteur";
		context.setInputStream(new ByteArrayInputStream(respContent.getBytes()));
		return context.proceed();
	}

}
