package ch.bebaforst.bebaweb;

import javax.servlet.annotation.WebServlet;

import ch.bebaforst.bebaweb.model.Dummy;
import ch.bebaforst.bebaweb.repository.DummyRepository;
import ch.bebaforst.bebaweb.service.HelloService;
import ch.bebaforst.bebaweb.util.SpringContextHelper;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "ch.bebaforst.bebaweb.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	private HelloService service;

	@Override
	protected void init(VaadinRequest request) {

		SpringContextHelper helper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());

		service = helper.getBean(HelloService.class);
		final DummyRepository dummyRepository = helper.getBean(DummyRepository.class);

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button(service.getString());
		button.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"));
				dummyRepository.save(new Dummy());
			}
		});
		layout.addComponent(button);
	}

}
