package ds222rr_assign3;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NorseGods extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage args) {
		args.setTitle("Norse Gods");
		
		// Descriptions for NorseGods
		String tyrDesc = 
				"Týr (/tɪər/; Old Norse: Týr [tyːr]) is a Germanic god associated with law and heroic glory in Norse mythology, portrayed as one-handed. Corresponding names in other Germanic languages are Gothic Teiws, Old English Tīw and Old High German Ziu and Cyo, all from Proto-Germanic *Tīwaz. The Latinised name is rendered as Tius or Tio and also formally as Mars Thincsus.\r\n"+
				"In the late Icelandic Eddas, Týr is portrayed, alternately, as the son of Odin (Prose Edda) or of Hymir (Poetic Edda), while the origins of his name and his possible relationship to Tuisto (see Tacitus' Germania) suggest he was once considered the father of the gods and head of the pantheon, since his name is ultimately cognate to that of *Dyeus (cf. Dyaus), the reconstructed chief deity in Indo-European religion. It is assumed that Tîwaz was overtaken in popularity and in authority by both Odin and Thor at some point during the Migration Age, as Odin shares his role as God of war.\r\n"+
				"Tiw was equated with Mars in the interpretatio germanica. Tuesday is \"Tīw's Day\" (also in Alemannic Zischtig from zîes tag), translating dies Martis.\r\n"+
				"Old Norse Týr, literally \"god\", plural tívar \"gods\", comes from Proto-Germanic *Tīwaz (cf. Old English Tīw, Old High German Zīo), which continues Proto-Indo-European *deiwós \"celestial being, god\" (cf. Welsh duw, Latin deus, Lithuanian diẽvas, Sanskrit dēvá, Avestan daēvō (false) \"god\"). And *deiwós is based in *dei-, *deyā-, *dīdyā-, meaning 'to shine'.\r\n"+
				"The earliest attestation for Týr's continental counterpart occurs in Gothic tyz \"the t-rune\" (𐍄) in the 9th-century Codex Vindobonensis 795. The name is later attested in Old High German as Cyo in the A Wessobrunn prayer manuscript of 814. The Negau helmet inscription (2nd century b.c.) may actually record the earliest form, teiva, but this interpretation is tentative.\r\n"+
				"Týr in origin was a generic noun meaning \"god\", e.g. Hangatyr, literally, the \"god of the hanged\", as one of Odin's names, which was probably inherited from Týr in his role as god of justice.[citation needed] The name continues on as Norwegian Tyr, Swedish Tyr, Danish Tyr, while it remains Týr in Modern Icelandic and Faroese.\r\n"+
				"gloss to the Wessobrunn prayer names the Alamanni Cyowari (worshipers of Cyo) and their capital Augsburg Ciesburc.\r\n"+
				"The Excerptum ex Gallica Historia of Ursberg (ca. 1135) records a dea Ciza as the patron goddess of Augsburg. According to this account, Cisaria was founded by Swabian tribes as a defence against Roman incursions. This Zisa would be the female consort of Ziu, as Dione was of Zeus.\r\n"+
				"The name of Mars Thingsus (Thincsus) is found in an inscription on a 3rd-century altar from the Roman fort and settlement of Vercovicium at Housesteads in Northumberland, thought to have been erected by Frisian mercenaries stationed at Hadrian's Wall. It is interpreted as \"Mars of the Thing\". Here is also worth noting what Tacitus stated in his work Germania about capital punishment amongst the Germanic folk; that none could be flogged, imprisoned or executed, not even on order of the warlord, without the consent of the priest; who was himself required to render his judgement in accordance with the will of the god they believe inspires them to the field of battle.\r\n"+
				"Tacitus also named the German \"Mars\" as the primary deity, along with the German \"Mercury\" (believed to be Odin), Hercules (believed to be Thor) and \"Isis\" (probably Freja). In the text however, Hercules is the one to be mentioned the most often. Depending on translation, \"Mercury\" is stated to be the chiefly worshipped god but other translation does not provide any sort of hierarchy among the gods. Tacitus states that \"Mars\" and \"Hercules\" receive animal sacrifices while \"Mercury\" receives human sacrifices.\r\n"+
				"In the Old English Rune Poem, the rune that is otherwise named for Tiw in the other rune poems (Abecedarium Nordmanicum, Old Norwegian Rune Rhyme, Old Icelandic Rune Poem), is called tir, meaning \"glory\". This rune was inscribed on more Anglo-Saxon cremation urns than any other symbol.\r\n"+
				"There is sketchy evidence of a consort, in German named Zisa: Tacitus mentions one Germanic tribe who worshipped \"Isis\", and Jacob Grimm pointed to Cisa/Zisa, the patroness of Augsburg, in this connection. The name Zisa could be derived from Ziu etymologically.\r\n"+
				"An early depiction of Týr is found on the IK 190 bracteate found near Trollhättan, Sweden. The figure is shown with long hair, holding a sceptre in one hand, and with a wolf biting his other hand.\r\n"+
				"According to the Poetic Edda and Prose Edda, at one stage the gods decided to shackle the Fenris wolf (Fenrir), but the beast broke every chain they put upon him. Eventually they had the dwarves make them a magical ribbon called Gleipnir. It appeared to be only a silken ribbon but was made of six wondrous ingredients: the sound of a cat's footfall, the beard of a woman, the roots of a mountain, bear's sinews (meaning nerves, sensibility), fish's breath and bird's spittle. The creation of Gleipnir is said to be the reason why none of the above exist. Fenrir sensed the gods' deceit and refused to be bound with it unless one of them put his hand in the wolf's mouth.\r\n"+
				"Týr, known for his great wisdom and courage, agreed, and the other gods bound the wolf. After Fenrir had been bound by the gods, he struggled to try to break the rope. Fenrir could not break the ribbon and, enraged, bit Týr's right hand off. When the gods saw that Fenrir was bound they all rejoiced, except Týr. Fenrir would remain bound until the day of Ragnarök. As a result of this deed, Týr is called the \"Leavings of the Wolf\"; which is to be understood as a poetic kenning for glory. As a consequence, however, his name is also associated with perjury. During the battle at Ragnarök, Fenrir swallows Odin whole.\r\n"+
				"According to the Prose version of Ragnarök, Týr is destined to kill and be killed by Garm, the guard dog of Hel. However, in the two poetic versions of Ragnarök, he goes unmentioned; unless one believes that he is the \"Mighty One\".\r\n"+
				"In Lokasenna, Týr is taunted with cuckoldry by Loki, maybe another hint that he had a consort or wife at one time.\r\n"+
				"In the Hymiskviða, Týr's father is named as the etin Hymir – the term \"Hymir's kin\" was used a kenning for etinkind – while his mother goes unnamed, but is otherwise described in terms that befit a goddess. This myth also pairs Týr with Thor, and draws a comparison between their strength via the lifting of Hymir's cauldron. Thor proves the stronger, but other than Thor's own son, Magni, Týr is the only deity whose strength is ever questioned in comparison to the Thunderer's.\r\n"+
				"Sigrdrífumál teaches runemagic and advises one to twice name Týr and carve \"victory runes\" on the sword hilt, presumably referring to the t rune.";
		String odinDesc = 
				"In Germanic mythology, Odin (from Old Norse Óðinn) is a widely revered god. In Norse mythology, from which stems most of the information about the god, Odin is associated with wisdom, healing, death, royalty, the gallows, knowledge, battle, sorcery, poetry, frenzy, and the runic alphabet, and is the husband of the goddess Frigg. In wider Germanic mythology and paganism, Odin was known in Old English as Wōden, in Old Saxon as Wōdan, and in Old High German as Wuotan or Wōtan, all stemming from the reconstructed Proto-Germanic theonym *wōđanaz.\r\n"+
				"Odin is a prominently mentioned god throughout the recorded history of the Germanic peoples, from the Roman occupation of regions of Germania through the tribal expansions of the Migration Period and the Viking Age. In the modern period, Odin continued to be acknowledged in the rural folklore of Germanic Europe. References to Odin appear in place names throughout regions historically inhabited by the ancient Germanic peoples, and the day of the week Wednesday bears his name in many Germanic languages, including English.\r\n"+
				"In Old English texts, Odin holds a particular place as a euhemerized ancestral figure among royalty, and he is frequently referred to as a founding figure among various other Germanic peoples, including the Langobards. Forms of his name appear frequently throughout the Germanic record, though narratives regarding Odin are mainly found in Old Norse works recorded in Iceland, primarily around the 13th century. These texts make up the bulk of modern understanding of Norse mythology.\r\n"+
				"In Old Norse texts, Odin is depicted as one-eyed and long-bearded, frequently wielding a spear named Gungnir, and wearing a cloak and a broad hat. He is often accompanied by his animal companions and familiars—the wolves Geri and Freki and the ravens Huginn and Muninn, who bring him information from all over Midgard—and rides the flying, eight-legged steed Sleipnir across the sky and into the underworld. Odin is attested as having many sons, most famously the gods Thor (with Jörð) and Baldr (with Frigg), and is known by hundreds of names. In these texts, he frequently seeks greater knowledge, at times in disguise (most famously by obtaining the Mead of Poetry), makes wagers with his wife Frigg over the outcome of exploits, and takes part in both the creation of the world by way of slaying the primordial being Ymir and the gift of life to the first two humans Ask and Embla. Odin has a particular association with Yule, and mankind's knowledge of both the runes and poetry is also attributed to him, giving Odin aspects of the culture hero.\r\n"+
				"In Old Norse texts, female beings associated with the battlefield—the valkyries—are associated with the god and Odin oversees Valhalla, where he receives half of those who die in battle, the einherjar. The other half are chosen by the goddess Freyja for her afterlife location, Fólkvangr. Odin consults the disembodied, herb-embalmed head of the wise being Mímir for advice, and during the foretold events of Ragnarök, Odin is told to lead the einherjar into battle before being consumed by the monstrous wolf Fenrir. In later folklore, Odin appears as a leader of the Wild Hunt, a ghostly procession of the dead through the winter sky. He is associated with charms and other forms of magic, particularly in Old English and Old Norse texts.\r\n"+
				"Odin is a frequent subject of study in Germanic studies, and numerous theories have been put forward regarding his development. Some of these focus on Odin's particular relation to other figures; for example, the fact that Freyja's husband Óðr appears to be something of an etymological doublet of the god, whereas Odin's wife Frigg is in many ways similar to Freyja, and that Odin has a particular relation to the figure of Loki. Other approaches focus on Odin's place in the historical record, a frequent question being whether the figure of Odin derives from Proto-Indo-European religion, or whether he developed later in Germanic society. In the modern period, Odin has inspired numerous works of poetry, music, and other forms of media. He is venerated in most forms of the new religious movement Heathenry, together with other gods venerated by the ancient Germanic peoples; some branches focus particularly on him.\r\n";
		String friggDesc = 
				"In Germanic mythology, Frigg (Old Norse), Frija (Old High German), Frea (Langobardic), and Frige (Old English) is a goddess. In nearly all sources, she is described as the wife of the god Odin. In Old High German and Old Norse sources, she is also connected with the goddess Fulla. The English weekday name Friday (etymologically Old English \"Frīge's day\") bears her name.\r\n"+
				"Frigg is described as a goddess associated with foreknowledge and wisdom in Norse mythology, the northernmost branch of Germanic mythology and most extensively attested. Frigg is the wife of the major god Odin and dwells in the wetland halls of Fensalir, is famous for her foreknowledge, is associated with the goddesses Fulla, Lofn, Hlín, and Gná, and is ambiguously associated with the Earth, otherwise personified as an apparently separate entity Jörð (Old Norse \"Earth\"). The children of Frigg and Odin include the gleaming god Baldr. Due to significant thematic overlap, scholars have proposed a particular connection to the goddess Freyja.\r\n"+
				"After Christianization, mention of Frigg continued to occur in Scandinavian folklore. In modern times, Frigg has appeared in modern popular culture, has been the subject of art, and receives modern veneration in Germanic Neopaganism.\r\n"+
				"The theonyms Frigg (Old Norse) and Frija (Old High German) are cognate forms—linguistic siblings of the same origin—that descend from a substantivized feminine of Proto-Germanic *frijaz (via Holtzmann's law). *frijaz descends from the same source (Proto-Indo-European) as the feminine Sanskrit noun priyā and the feminine Avestan noun fryā (both meaning \"own, dear, beloved\"). In the modern period, an -a suffix is sometimes applied to denote femininity, resulting in the form Frigga. This spelling also serves the purpose of distancing the goddess from the English word frig.\r\n"+
				"The connection with and possible earlier identification of the goddess Freyja with Frigg in the Proto-Germanic period (Frigg and Freyja origin hypothesis) is a matter of scholarly debate. The name Freyja is not attested outside of Scandinavia, like the name of the group of gods to which Freyja belongs, the Vanir. This is in contrast to the name of the goddess Frigg, who is attested as a goddess common among the Germanic peoples, and whose name is reconstructed as Proto-Germanic *Frijjō. Evidence does not exist for the existence of a common Germanic goddess from which Old Norse Freyja descends, but scholars have commented that this may simply be due to the scarcity of surviving sources.\r\n"+
				"Regarding a Freyja-Frigg common origin hypothesis, scholar Stephan Grundy comments that \"the problem of whether Frigg or Freyja may have been a single goddess originally is a difficult one, made more so by the scantiness of pre-Viking Age references to Germanic goddesses, and the diverse quality of the sources. The best that can be done is to survey the arguments for and against their identity, and to see how well each can be supported.\"\r\n"+
				"The English weekday name Friday comes from Old English Frīġedæġ, meaning 'day of Frige'. It is cognate with Old High German frîatac. Several place names refer to Frigg in what are now Norway and Sweden, although her name is altogether absent in recorded place names in Denmark.";
		String thorDesc = 
				"In Norse mythology, Thor (/θɔːr/; from Old Norse Þórr) is the hammer-wielding Æsir god of thunder and lightning, associated with storms, oak trees, strength, hallowing, fertility, the protection of mankind and of the fortress of Asgard. The son of Odin All-Father and Jörð (the personification of Earth), he is physically the strongest of the Æsir. The cognate deity in wider Germanic mythology and paganism was known in Old English as Þunor (Thunor) and in Old High German as Donar (runic þonar ᚦᛟᚾᚨᚱ), stemming from a Proto-Germanic *Þunraz, meaning \"thunder\".\r\n"+
				"Thor is a prominently mentioned god throughout the recorded history of the Germanic peoples, from the Roman occupation of regions of Germania, to the tribal expansions of the Migration Period, to his high popularity during the Viking Age, when, in the face of the process of the Christianization of Scandinavia, emblems of his hammer, Mjölnir, were worn and Norse pagan personal names containing the name of the god bear witness to his popularity.\r\n"+
				"Into the modern period, Thor continued to be acknowledged in rural folklore throughout Germanic regions. Thor is frequently referred to in place names, the day of the week Thursday (\"Thor's day\" derived from Old English Þūnresdæg - \"Thunor's day\"; originally Þorsdagr in Old Norse) bears his name, and names stemming from the pagan period containing his own continue to be used today.\r\n"+
				"In Norse mythology, largely recorded in Iceland from traditional material stemming from Scandinavia, numerous tales and information about Thor are provided. In these sources, Thor bears at least fifteen names, is the husband of the golden-haired goddess Sif, is the lover of the jötunn Járnsaxa, and is generally described as fierce eyed, red haired and red bearded. With Sif, Thor fathered the goddess (and possible Valkyrie) Þrúðr; with Járnsaxa, he fathered Magni; with a mother whose name is not recorded, he fathered Móði, and he is the stepfather of the god Ullr. By way of Odin, Thor has numerous brothers, including Baldr. Thor has two servants, Þjálfi and Röskva, rides in a cart or chariot pulled by two goats, Tanngrisnir and Tanngnjóstr (that he eats and resurrects), and is ascribed three dwellings (Bilskirnir, Þrúðheimr, and Þrúðvangr). Thor wields the mountain-crushing hammer, Mjölnir, wears the belt Megingjörð and the iron gloves Járngreipr, and owns the staff Gríðarvölr. Thor's exploits, including his relentless slaughter of his foes and fierce battles with the monstrous serpent Jörmungandr—and their foretold mutual deaths during the events of Ragnarök—are recorded throughout sources for Norse mythology.\r\n"+
				"Thor has inspired numerous works of art and references to Thor appear in modern popular culture. Like other Germanic deities, veneration of Thor is revived in the modern period in Heathenry.";
		String freyrDesc = 
				"Freyr (Old Norse: Lord), sometimes anglicized as Frey, is a widely attested god associated with sacral kingship, virility and prosperity, with sunshine and fair weather, and pictured as a phallic fertility god in Norse mythology. Freyr is said to \"bestow peace and pleasure on mortals.\" Freyr, sometimes referred to as Yngvi-Freyr, was especially associated with Sweden and seen as an ancestor of the Swedish royal house.\r\n"+
				"In the Icelandic books the Poetic Edda and the Prose Edda, Freyr is presented as one of the Vanir, the son of the sea god Njörðr, as well as the twin brother of the goddess Freyja. The gods gave him Álfheimr, the realm of the Elves, as a teething present. He rides the shining dwarf-made boar Gullinbursti and possesses the ship Skíðblaðnir which always has a favorable breeze and can be folded together and carried in a pouch when it is not being used. He has the servants Skírnir, Byggvir and Beyla.\r\n"+
				"The most extensive surviving Freyr myth relates Freyr's falling in love with the female jötunn Gerðr. Eventually, she becomes his wife but first Freyr has to give away his magic sword which fights on its own \"if wise be he who wields it.\" Although deprived of this weapon, Freyr defeats the jötunn Beli with an antler. However, lacking his sword, Freyr will be killed by the fire jötunn Surtr during the events of Ragnarök.\r\n"+
				"Like other Germanic deities, veneration of Freyr is revived in the modern period in Heathenry movement.";
		String freyjaDesc = 
				"In Norse mythology, Freyja (/ˈfreɪə/; Old Norse for \"(the) Lady\") is a goddess associated with love, sex, beauty, fertility, gold, seiðr, war, and death. Freyja is the owner of the necklace Brísingamen, rides a chariot pulled by two cats, accompanied by the boar Hildisvíni, and possesses a cloak of falcon feathers. By her husband Óðr, she is the mother of two daughters, Hnoss and Gersemi. Along with her twin brother Freyr, her father Njörðr, and her mother (Njörðr's sister, unnamed in sources), she is a member of the Vanir. Stemming from Old Norse Freyja, modern forms of the name include Freya, Freyia, and Freja.\r\n"+
				"Freyja rules over her heavenly field Fólkvangr and there receives half of those that die in battle, whereas the other half go to the god Odin's hall, Valhalla. Within Fólkvangr lies her hall, Sessrúmnir. Freyja assists other deities by allowing them to use her feathered cloak, is invoked in matters of fertility and love, and is frequently sought after by powerful jötnar who wish to make her their wife. Freyja's husband, the god Óðr, is frequently absent. She cries tears of red gold for him, and searches for him under assumed names. Freyja has numerous names, including Gefn, Hörn, Mardöll, Sýr, Valfreyja, and Vanadís.\r\n"+
				"Freyja is attested in the Poetic Edda, compiled in the 13th century from earlier traditional sources; in the Prose Edda and Heimskringla, composed by Snorri Sturluson in the 13th century; in several Sagas of Icelanders; in the short story Sörla þáttr; in the poetry of skalds; and into the modern age in Scandinavian folklore.\r\n"+
				"Scholars have debated whether Freyja and the goddess Frigg ultimately stem from a single goddess common among the Germanic peoples; connected her connection to the valkyries, female battlefield choosers of the slain; and analyzed her relation to other goddesses and figures in Germanic mythology, including the thrice-burnt and thrice-reborn Gullveig/Heiðr, the goddesses Gefjon, Skaði, Þorgerðr Hölgabrúðr and Irpa, Menglöð, and the 1st century CE \"Isis\" of the Suebi. Freyja's name appears in numerous place names in Scandinavia, with a high concentration in southern Sweden. Various plants in Scandinavia once bore her name, but it was replaced with the name of the Virgin Mary during the process of Christianization. Rural Scandinavians continued to acknowledge Freyja as a supernatural figure into the 19th century, and Freyja has inspired various works of art.";
		String heimdallrDesc = 
				"In Norse mythology, Heimdallr is a god who possesses the resounding horn Gjallarhorn, owns the golden-maned horse Gulltoppr, has gold teeth, and is the son of Nine Mothers, grandson of Aegir and great grandson of Fornjotr. Heimdallr is attested as possessing foreknowledge, keen eyesight and hearing, and keeps watch for the onset of Ragnarök while drinking fine mead in his dwelling Himinbjörg, located where the burning rainbow bridge Bifröst meets heaven. Heimdallr is said to be the originator of social classes among humanity and once regained Freyja's treasured possession Brísingamen while doing battle in the shape of a seal with Loki. Heimdallr and Loki are foretold to kill one another during the events of Ragnarök. Heimdallr is additionally referred to as Rig, Hallinskiði, Gullintanni, and Vindlér or Vindhlér.\r\n"+
				"Heimdallr is attested in the Poetic Edda, compiled in the 13th century from earlier traditional material; in the Prose Edda and Heimskringla, both written in the 13th century by Snorri Sturluson; in the poetry of skalds; and on an Old Norse runic inscription found in England. Two lines of an otherwise lost poem about the god, Heimdalargaldr, survive. Due to the problematic and enigmatic nature of these attestations, scholars have produced various theories about the nature of the god, including his apparent relation to rams, that he may be a personification of or connected to the world tree Yggdrasil, and potential Indo-European cognates.";
		String fenrirDesc = 
				"Fenrir (Old Norse: \"fen-dweller\") or Fenrisúlfr (Old Norse: \"Fenrir's wolf\", often translated \"Fenris-wolf\"), also referred to as Hróðvitnir (\"fame-wolf\") and Vánagandr (\"monster of the [River] Ván\"), is a monstrous wolf in Norse mythology. Fenrir is attested in the Poetic Edda, compiled in the 13th century from earlier traditional sources, and the Prose Edda and Heimskringla, written in the 13th century by Snorri Sturluson. In both the Poetic Edda and Prose Edda, Fenrir is the father of the wolves Sköll and Hati Hróðvitnisson, is a son of Loki, and is foretold to kill the god Odin during the events of Ragnarök, but will in turn be killed by Odin's son Víðarr.\r\n"+
				"In the Prose Edda, additional information is given about Fenrir, including that, due to the gods' knowledge of prophecies foretelling great trouble from Fenrir and his rapid growth, the gods bound him, and as a result Fenrir bit off the right hand of the god Týr. Depictions of Fenrir have been identified on various objects, and scholarly theories have been proposed regarding Fenrir's relation to other canine beings in Norse mythology. Fenrir has been the subject of artistic depictions, and he appears in literature.";
		
		// Heading
		Label heading = new Label("Norse Gods and other Beings");
		heading.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		heading.setPadding(new Insets(0, 0, 10, 0));
		
		// ListView for NorseGods
		ListView<String> nordicGods = new ListView<>();
		nordicGods.setPrefHeight(450);
		nordicGods.setPrefWidth(200);
		nordicGods.getItems().addAll("Tyr", "Odin", "Frigg", "Thor",
									 "Freyr", "Freyja", "Heimdallr", "Fenrir");
		
		// Labels for Name, Race, Description
		Label god = new Label("Tyr");
		god.setFont(Font.font("Arial", 30));
		Label race = new Label("Aesir");
		race.setFont(Font.font("Arial", FontPosture.ITALIC, 15));
		Label emp = new Label("");
		Text desc = new Text(tyrDesc);
		desc.setWrappingWidth(530);
		
		// ScrollPane for Description
		ScrollPane sp = new ScrollPane();
		sp.setContent(desc);
		sp.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setFitToWidth(true);

		// VBox for Labels
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(0, 0, 0, 10));
		vBox.setStyle("-fx-border-color: gray;");
		vBox.getChildren().addAll(god, race, emp, sp);

		// ArrayList for NorseGods
		String[] nameArr = {"Tyr", "Odin", "Frigg", "Thor", "Freyr", "Freyja", "Heimdallr", "Fenrir"};
		String[] raceArr = {"Aesir", "Aesir", "Aesir", "Aesir", "Vanir", "Vanir", "Aesir", "Other"};
		String[] descArr = {tyrDesc, odinDesc, friggDesc, thorDesc, freyrDesc, freyjaDesc, heimdallrDesc, fenrirDesc};
		final ArrayList<NorseGod> arrList = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			NorseGod norseGod = new NorseGod();
			norseGod.setName(nameArr[i]);
			norseGod.setRace(raceArr[i]);
			norseGod.setDesc(descArr[i]);
			arrList.add(norseGod);
		}
		
		// BorderPane
		BorderPane bPane = new BorderPane();
		bPane.setPadding(new Insets(10, 10, 10, 10));
		bPane.setTop(heading);
		bPane.setLeft(nordicGods);
		bPane.setCenter(vBox);
		Insets insets = new Insets(5);
		BorderPane.setMargin(vBox, insets);
		BorderPane.setMargin(nordicGods, insets);
		BorderPane.setMargin(heading, insets);

		// Listener
		nordicGods.getSelectionModel().selectedIndexProperty().addListener(a -> {
			god.setText(arrList.get(nordicGods.getSelectionModel().getSelectedIndex()).getName());
			race.setText(arrList.get(nordicGods.getSelectionModel().getSelectedIndex()).getRace());
			desc.setText(arrList.get(nordicGods.getSelectionModel().getSelectedIndex()).getDesc());
		});
	
		Scene scene = new Scene(bPane, 800, 600);		
		args.setTitle("Norse Gods");
	    args.setResizable(false);
		args.setScene(scene);
		args.show();
	}

	// Private inner class
	private  class NorseGod {
	
		private String name;
		private String race;
		private String desc;
	
		// Constructor
		public NorseGod() {
		
		}
	
//		public NorseGod(String n, String r, String d) {
//			name = n;
//			race = r;
//			desc = d;
//		}
	
		public String getName() {
			return name;
		}
	
		public String getRace() {
			return race;
		}
	
		public String getDesc() {
			return desc;
		}
	
		public void setName(String n) {
			name = n;
		}
	
		public void setRace(String r) {
			race = r;
		}
	
		public void setDesc(String d) {
			desc = d;
		}
	}
}