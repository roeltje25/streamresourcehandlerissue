package com.example;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.StreamResource;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base", enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

	public MainView() {
		StreamResource faulty = new StreamResource("you-should-not-see-this-download.pdf", () -> {
			throw new IllegalStateException("Oops we cannot generate the stream");
		});
		Anchor anchor = new Anchor(faulty, "Click Here");
		anchor.getElement().setAttribute("download", true);

		add(anchor);
	}
}
