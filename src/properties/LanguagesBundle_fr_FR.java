package properties;

import java.util.ListResourceBundle;

public class LanguagesBundle_fr_FR extends ListResourceBundle {
	protected Object[][] contents = {
			{"Choose SLogo Language","Choisir la langue SLogo"},
			{"Turtle Image","L'image de la Tortue"},
			{"Turtle Toggle","Choisir la Tortue"},
			{"Grid Toggle","Choisir la visibilit� du Grid"},
			{"Color","Couleur"},
			{"Enter","Entr�e"}
	};
	
	@Override
	protected Object[][] getContents() {
		return contents;
	}
}
