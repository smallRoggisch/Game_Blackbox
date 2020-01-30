package gameplay.game;

import gameplay.treeobjects.Answer;
import gameplay.treeobjects.Messagetype;
import gameplay.treeobjects.Node;
import gameplay.treeobjects.NodeMessage;
import sun.plugin2.message.Message;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ScenarioCreator {

    private static List<Node> scenarioOne = null;
    private static List<Node> scenarioTwo = null;

    public ScenarioCreator()
    {
        scenarioOne = createScenarioOne();
        scenarioTwo = createScenarioTwo();
    }

    public List<Node> createScenarioOne()
    {
        List<Node> nodeList = new ArrayList<Node>();

        //Declaring all Nodes
        Node ausgangssituation = null;
        nodeList.add(ausgangssituation);
        Node a2 = null;
        nodeList.add(a2);
        Node kd42 = null;
        nodeList.add(kd42);
        Node sd87 = null;
        nodeList.add(sd87);
        Node skd56 = null;
        nodeList.add(skd56);
        Node ending1 = null;
        nodeList.add(ending1);
        Node c1 = null;
        nodeList.add(c1);
        Node c2 = null;
        nodeList.add(c2);
        Node c3 = null;
        nodeList.add(c3);
        Node c3Alternativ = null;
        nodeList.add(c3Alternativ);
        Node f1 = null;
        nodeList.add(f1);
        Node f2 = null;
        nodeList.add(f2);
        Node f3 = null;
        nodeList.add(f3);
        Node ending2 = null;
        nodeList.add(ending2);
        Node d = null;
        nodeList.add(d);
        Node d1 = null;
        nodeList.add(d1);
        Node d2 = null;
        nodeList.add(d2);
        Node d3 = null;
        nodeList.add(d3);
        Node g1 = null;
        nodeList.add(g1);
        Node ending4 = null;
        nodeList.add(ending4);
        Node e1 = null;
        nodeList.add(e1);
        Node e2 = null;
        nodeList.add(e2);
        Node e3 = null;
        nodeList.add(e3);
        Node e4 = null;
        nodeList.add(e4);
        Node ending5 = null;
        nodeList.add(ending5);
        Node ending6 = null;
        nodeList.add(ending6);
        Node ending7 = null;
        nodeList.add(ending7);

        //Filling Nodes with values
        //Ausgangssituation
        LinkedList<Answer> answersForCurrentNode = new LinkedList<Answer>();
        Answer answer1 = new Answer("Kann das nicht jemand anderes übernehmen? Ich stecke immer noch in den Ermittlungen bezüglich der Wasserleiche vom Frühlinger See fest.", ending1);
        answersForCurrentNode.add(answer1);
        Answer answer2 = new Answer("Supi, worum geht's?", a2);
        answersForCurrentNode.add(answer2);
        LinkedList<NodeMessage> messageList = new LinkedList<NodeMessage>();
        NodeMessage message1 = new NodeMessage(Messagetype.Text, "Hey Joe, ich hab da einen neuen Fall für dich.", "Kommissar Thomas");
        messageList.add(message1);
        ausgangssituation = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //a2
        answer1 = new Answer("Hört sich spannend an. Leider hab ich gerade keinen Droiden frei, der diese Aufgaben übernehmen kann.", ending1);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Okay ich schicke schonmal einen Kontaktdroiden los. Leitest du mir die Akte weiter?", kd42);
        answersForCurrentNode.add(answer2);
        Answer answer3 = new Answer("Okay ich schicke schonmal einen Spurendroiden los. Leitest du mir die Akte weiter?", sd87);
        answersForCurrentNode.add(answer3);
        Answer answer4 = new Answer("Okay ich schicke schonmal einen Spuren- und Kontaktdroiden los. Leitest du mir die Akte weiter?", skd56);
        answersForCurrentNode.add(answer4);
        message1 = new NodeMessage(Messagetype.Text, "Eine junge Frau hat soeben einen toten Mann in ihrer Wohnung gefunden. Sie steht jetzt unter Schock. Jemand muss zu ihr, sie befragen und die Spuren müssen dort gesichert werden.", "Kommissar Thomas");
        messageList.add(message1);
        a2 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //Ending1
        message1 = new NodeMessage(Messagetype.Text, "Es wurde zu spät gehandelt: Circa 30 Minuten nach dem ANruf bei der Polizei hat sich Frau Müller erinnert, was passiert ist. Sie geriet in Panik und setzte die Wohnung in Flammen. So konnte der Mord und das Motiv nicht aufgeklärt werden.", "Erzähler" );
        messageList.add(message1);
        ending1 = new Node(messageList, answersForCurrentNode);
        messageList.clear();

        //KD42
        answer1 = new Answer("Droide beruhige die Frau", c1);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Befrage sie und finde heraus, an was sie sich erinnert.", c2);
        answersForCurrentNode.add(answer2);
        message1 = new NodeMessage(Messagetype.Text, "Klar. Danke, dass du das übernimmst! Halte mich auf dem Laufenden.", "Kommissar Thomas");
        messageList.add(message1);
        NodeMessage message2 = new NodeMessage(Messagetype.Image, "", 30, "Kommissar Thomas");
        messageList.add(message2);
        NodeMessage message3 = new NodeMessage(Messagetype.Text, "Ich bin bei Frau Müller angekommen.","Droide");
        messageList.add(message3);
        NodeMessage messgae4 = new NodeMessage(Messagetype.Image, "", "Droide");
        messageList.add(messgae4);
        kd42 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //SD87
        answer1 = new Answer("Schaue dir den Tartort genauer an und entnehme Proben für das Labor", c3);
        answersForCurrentNode.add(answer1);
        message1 = new NodeMessage(Messagetype.Text, "Klar. Danke, dass du das übernimmst! Halte mich auf dem Laufenden.", "Kommissar Thomas");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Image, "", 30, "Kommissar Thomas");
        messageList.add(message2);
        message3 = new NodeMessage(Messagetype.Text, "Ich bin bei Frau Müller angekommen.", "Droide");
        messageList.add(message3);
        messgae4 = new NodeMessage(Messagetype.Image, "", "Droide");
        messageList.add(messgae4);
        sd87 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //SKD56
        answer1 = new Answer("Droide beruhige die Frau", c1);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Befrage sie und finde heraus, an was sie sich erinnert.", c2);
        answersForCurrentNode.add(answer2);
        answer3 = new Answer("Schaue dir den Tartort genauer an und entnehme Proben für das Labor", c3);
        answersForCurrentNode.add(answer3);
        message1 = new NodeMessage(Messagetype.Text, "Klar. Danke, dass du das übernimmst! Halte mich auf dem Laufenden.", "Kommissar Thomas");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Image, "", 30, "Kommissar Thomas");
        messageList.add(message2);
        message3 = new NodeMessage(Messagetype.Text, "Ich bin bei Frau Müller angekommen.", "Droide");
        messageList.add(message3);
        messgae4 = new NodeMessage(Messagetype.Image, "", "Droide");
        messageList.add(messgae4);
        skd56 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //Ending2
        message1 = new NodeMessage(Messagetype.Text, "Beim Versuch die Frau zu beruhigen wurde Frau Müller hysterisch und schlug den Druiden gegen die Wand, sodass er beschädigt wurde und die Verbindung abbrach. Während ein Neustart versucht wurde, hat die Frau alle Beweise beseitigt und einen Brand gelegt. So konnte der Mord und das Motiv nicht aufgeklärt werden.", "Erzähler");
        messageList.add(message1);
        ending2 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //C2
        answer1 = new Answer("Weiß sie, warum ihr Vater un der Wohnung ist?", f1);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Hatte jemand einen Grund ihn umzubringen?", f2);
        answersForCurrentNode.add(answer2);
        answer3= new Answer("Hatte Frau Müller irgendwelche Feinde oder möglicherweise berufsbedingt Neider?", f3);
        answersForCurrentNode.add(answer3);
        message1 = new NodeMessage(Messagetype.Text, "Beim Opfer handelt es sich um den Vater der Frau. Wir befinden uns in der Wohnung der Frau. Sie hat ihren Vater erstochen aufgefunden als sie vom Einkaufen zurückkam.", "Droide");
        messageList.add(message1);
        c2 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //C3
        answer1 = new Answer("Schaue dich weiter um und halte Ausschau nach der Mordwaffe", d);
        answersForCurrentNode.add(answer1);
        message1 = new NodeMessage(Messagetype.Text, "Ich habe Blutproben und Fingerabdrücke sichergestellt. Eine Drohne ist jetzt auf dem Weg ins Labor. Es sieht nach einer tödlichen Stichverletzung aus. Es befindet sich keine Mordwaffe am  unmittelbaren Tatort", "Droide");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Text, "Okay, ich schicke dir den Spu-Si-Trupp zur Unterstützung.", "Droide");
        messageList.add(message2);
        c3 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //C3Alternativ
        answer1 = new Answer("Schaue dich weiter um und halte Ausschau nach der Mordwaffe", d);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Droide beruhige die Frau", c1);
        answersForCurrentNode.add(answer2);
        answer3 = new Answer("Befrage sie und finde heraus, an was sie sich erinnert.", c2);
        answersForCurrentNode.add(answer3);
        message1 = new NodeMessage(Messagetype.Text, "Ich habe Blutproben und Fingerabdrücke sichergestellt. Eine Drohne ist jetzt auf dem Weg ins Labor. Es sieht nach einer tödlichen Stichverletzung aus. Es befindet sich keine Mordwaffe am  unmittelbaren Tatort", "Droide");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Text, "Okay, ich schicke dir den Spu-Si-Trupp zur Unterstützung.", "Droide");
        messageList.add(message2);
        c3Alternativ = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //f1
        answer1 = new Answer("Hatte jemand einen Grund ihn umzubringen?", f2);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Hat Frau Müller irgendwelche Feinde oder möglicherweise berufsbedingt Neider?", f3);
        answersForCurrentNode.add(answer2);
        message1 = new NodeMessage(Messagetype.Text, "Sie sagt, sie ist als Bloggerin viel unterwegs, deshalb hat er einen Schlüssel, um ihre Katze zu versorgen", "Droide");
        messageList.add(message1);
        f1= new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //f2
        answer1 = new Answer("Hat Frau Müller irgendwelche Feinde oder möglicherweise berufsbedingt Neider?", f3);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Weiß sie, warum ihr Vater un der Wohnung ist?", f1);
        answersForCurrentNode.add(answer2);
        message1 = new NodeMessage(Messagetype.Text, "Sie weiß nichts von möglichen Feinden", "Droide");
        messageList.add(message1);
        f2 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //f3
        answer1 = new Answer("Sehr gut, lass dir die Email zeigen und leite sie an mich weite.", ending4);
        answersForCurrentNode.add(answer1);
        message1 = new NodeMessage(Messagetype.Text, "„Guter Ansatzpunkt. Vielleicht hatte es der Mörder eigentlich auf sie abgesehen und ihr Vater war zur falschen Zeit am falschen Ort…",30, "Droide");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Text, "Ja, sie hat letztens eine Droh-Email erhalten", "Droide");
        c3 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //ending4
        message1 = new NodeMessage(Messagetype.Text,"Als die Frau den Laptop entsperrte, um dem Droiden die ominöse Droh-Email zu zeigen, war direkt ein Video zu sehen. Die Webkam hatte den Mord aufgezeichnet…!! Frau Müller hat ihren Vater mit einem Küchenmesser erstochen. Als sie dies auf dem Bildschirm sah, wurde sie hysterisch und schlug den Droiden gegen die Wand, sodass er beschädigt wurde und die Verbindung abbrach. Während ein Neustart versucht wurde, hat die Frau die restlichen Beweise beseitigt und einen Brand gelegt. So konnte ihr Motiv nicht aufgklärt werden","Erzähler");
        messageList.add(message1);
        ending4 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //d
        answer1 = new Answer("Geh ins Badezimmer.", d1);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Starte in der Küche.", d2);
        answersForCurrentNode.add(answer2);
        answer3 = new Answer("Fang im Wohnzimmer an",d3);
        answersForCurrentNode.add(answer3);
        message1 = new NodeMessage(Messagetype.Text, "Wo soll ich anfangen?", "Droide");
        messageList.add(message1);
        d = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //d1
        answer1 = new Answer(" Epilepsie-Tabletten ", ending5);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Schlaftabletten", ending5);
        answersForCurrentNode.add(answer2);
        answer3 = new Answer(" Schizophrenie-Tabletten", ending6);
        answersForCurrentNode.add(answer3);
        answer4 = new Answer("Magersucht-Tableetten", ending5);
        message1 = new NodeMessage(Messagetype.Image, "", "Droide");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Text, "Das ist das einzige Auffällige, das ich gefunden habe. Kannst du herausfinden, was das für Tabletten sind", "Droide");
        messageList.add(message2);
        message3 = new NodeMessage(Messagetype.Text, "Kannst du mir noch eine Nahaufnahme schicken?", "Ich");
        messageList.add(message3);
        messgae4 = new NodeMessage(Messagetype.Image, "","Droide");
        messageList.add(messgae4);
        NodeMessage message5 = new NodeMessage(Messagetype.Text, "Ok ich google jetzt", "Ich");
        d1 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //d2
        answer1 = new Answer("Schicke eine Drohne mit der möglichen Mordwaffe los und schau dich weiter um", g1);
        answersForCurrentNode.add(answer1);
        message1 = new NodeMessage(Messagetype.Image, "", "Droide");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Text, "Hier wurde gekocht, die Dunstabzugshaube läuft noch.",10, "Droide");
        messageList.add(message2);
        message3 = new NodeMessage(Messagetype.Text, "In der Spüle liegt ein Küchenmesser- möglicherweise die Mordwaffe.","Droide");
        messageList.add(message3);
        messgae4 = new NodeMessage(Messagetype.Image, "", "Droide");
        messageList.add(messgae4);
        message5 = new NodeMessage(Messagetype.Text, "Sehr gut!", "Ich");
        d2 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //d3
        answer1 = new Answer("Das ist ja interessant.", ending7);
        answersForCurrentNode.add(answer1);
        messgae4 = new NodeMessage(Messagetype.Text, "Ich habe Frau Müller ins Bad geschickt, um sich ein wenig frisch zu machen.", "Droide");
        messageList.add(messgae4);
        message1 = new NodeMessage(Messagetype.Image, "", 10, "Droide");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Text, "Ich habe einen Laptop sichergestellt. Es befindet sich darauf ein Video. Anscheinend hat die Webcam den Mord aufgezeichnet.", "Droide");
        messageList.add(message2);
        message3 = new NodeMessage(Messagetype.Video, "", 10, "Droide");
        d3 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //g1
        answer1 = new Answer("Geh ins Bad", d1);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Geh ins Wohnzimmer", d3);
        answersForCurrentNode.add(answer2);
        g1 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //ending5
        message1 = new NodeMessage(Messagetype.Text, "Die Frau ist verschwunden", "Droide");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Text,"Frau Müller ist zwar in der Zwischenzeit verschwunden, jedoch konnten die Mordwaffe, ein Küchenmesser, und ein Beweisvideo, das per Webcam eines Laptops im Wohnzimmer mitgeschnitten wurde, sichergestellt werden. Der Mord konnte somit aufgeklärt werden. Jedoch wurden die Tabletten falsch identifiziert, sodass das Motiv der Frau unklar bleibt","Erzähler");
        messageList.add(message2);
        ending5 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //ending6
        message1 = new NodeMessage(Messagetype.Text, "Die Frau ist verschwunden", "Droide");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Text,"Frau Müller ist zwar in der Zwischenzeit verschwunden, jedoch konnten die Mordwaffe, ein Küchenmesser, und ein Beweisvideo, das per Webcam eines Laptops im Wohnzimmer mitgeschnitten wurde, sichergestellt werden. Die Tabletten haben die Schizophrenie der Frau aufgedeckt. So konnte sowohl der Mord, als auch das Motiv der Frau aufgeklärt werden.","Erzähler");
        messageList.add(message2);
        ending6 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //ending7
        message1 = new NodeMessage(Messagetype.Text, "Die Frau ist verschwunden", "Droide");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Text,"Als Frau Müller ins Bad ging, konnte sie sich wieder erinnern, was passiert ist. Sie wurde hysterisch und schlug den Droiden gegen die Wand, sodass er beschädigt wurde und die Verbindung abbrach. Während ein Neustart versucht wurde, hat die Frau die restlichen Beweise beseitigt und einen Brand gelegt. Glücklicherweise hatte der Droide schon kurz vorher das Video weitergeleitet, sodass der Mord aufgeklärt werden konnte. Das Motiv bleibt jedoch unklar aufgrund mangelnder Beweise","Erzähler");
        messageList.add(message2);
        ending7 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        return nodeList;
    }

    public List<Node> createScenarioTwo()
    {
        List<Node> nodeList = new ArrayList<Node>();

        return nodeList;
    }

    public Node getFirstNode(long scenarioID) {
        if(scenarioID==0){
            return scenarioOne.get(0);
        }
        else if(scenarioID==1){
            return scenarioTwo.get(0);
        }
        //TODO exeptions
        return null;
    }
}
