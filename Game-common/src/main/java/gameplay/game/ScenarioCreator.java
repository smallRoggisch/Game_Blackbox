package gameplay.game;

import gameplay.treeobjects.Answer;
import gameplay.treeobjects.Messagetype;
import gameplay.treeobjects.Node;
import gameplay.treeobjects.NodeMessage;

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
        Node b = null;
        nodeList.add(b);
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
        Node z = null;
        nodeList.add(z);
        Node f1 = null;
        nodeList.add(f1);
        Node f2 = null;
        nodeList.add(f2);
        Node f3 = null;
        nodeList.add(f3);
        Node ending2 = null;
        nodeList.add(ending2);
        Node ending3 = null;
        nodeList.add(ending3);
        Node d = null;
        nodeList.add(d);
        Node dAlternative = null;
        nodeList.add(dAlternative);
        Node d1 = null;
        nodeList.add(d1);
        Node d2 = null;
        nodeList.add(d2);
        Node d2alternative = null;
        nodeList.add(d2alternative);
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

        //Filling Nodes with values
        //Ausgangssituation
        LinkedList<Answer> answersForCurrentNode = new LinkedList<Answer>();
        Answer answer1 = new Answer("Kann das nicht jemand anderes übernehmen? Ich stecke immer noch in den Ermittlungen bezüglich der Wasserleiche vom Frühlinger See fest.", ending1);
        answersForCurrentNode.add(answer1);
        Answer answer2 = new Answer("Supi, worum geht's?", a2);
        answersForCurrentNode.add(answer2);
        LinkedList<NodeMessage> messageList = new LinkedList<NodeMessage>();
        NodeMessage message1 = new NodeMessage(Messagetype.Text, "Hey Joe, ich hab da einen neuen Fall für dich.", "");
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
        message1 = new NodeMessage(Messagetype.Text, "Eine junge Frau hat soeben einen toten Mann in ihrer Wohnung gefunden. Sie steht jetzt unter Schock. Jemand muss zu ihr, sie befragen und die Spuren müssen dort gesichert werden.", "");
        messageList.add(message1);
        a2 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //Ending1
        message1 = new NodeMessage(Messagetype.Text, "Es wurde zu spät gehandelt: Circa 30 Minuten nach dem ANruf bei der Polizei hat sich Frau Müller erinnert, was passiert ist. Sie geriet in Panik und setzte die Wohnung in Flammen. So konnte der Mord und das Motiv nicht aufgeklärt werden.", "" );
        messageList.add(message1);
        ending1 = new Node(messageList, answersForCurrentNode);
        messageList.clear();

        //KD42
        answer1 = new Answer("Droide beruhige die Frau", c1);
        answersForCurrentNode.add(answer1);
        answer2 = new Answer("Befrage sie und finde heraus, an was sie sich erinnert.", c2);
        answersForCurrentNode.add(answer2);
        message1 = new NodeMessage(Messagetype.Text, "Klar. Danke, dass du das übernimmst! Halte mich auf dem Laufenden.", "");
        messageList.add(message1);
        NodeMessage message2 = new NodeMessage(Messagetype.Image, "", 30, "");
        messageList.add(message2);
        NodeMessage message3 = new NodeMessage(Messagetype.Text, "Ich bin bei Frau Müller angekommen.","");
        messageList.add(message3);
        NodeMessage messgae4 = new NodeMessage(Messagetype.Image, "", "");
        messageList.add(messgae4);
        kd42 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //SD87
        answer1 = new Answer("Schaue dir den Tartort genauer an und entnehme Proben für das Labor", c3);
        answersForCurrentNode.add(answer1);
        message1 = new NodeMessage(Messagetype.Text, "Klar. Danke, dass du das übernimmst! Halte mich auf dem Laufenden.", "");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Image, "", 30, "");
        messageList.add(message2);
        message3 = new NodeMessage(Messagetype.Text, "Ich bin bei Frau Müller angekommen.", "");
        messageList.add(message3);
        messgae4 = new NodeMessage(Messagetype.Image, "", "");
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
        message1 = new NodeMessage(Messagetype.Text, "Klar. Danke, dass du das übernimmst! Halte mich auf dem Laufenden.", "");
        messageList.add(message1);
        message2 = new NodeMessage(Messagetype.Image, "", 30, "");
        messageList.add(message2);
        message3 = new NodeMessage(Messagetype.Text, "Ich bin bei Frau Müller angekommen.", "");
        messageList.add(message3);
        messgae4 = new NodeMessage(Messagetype.Image, "", "");
        messageList.add(messgae4);
        skd56 = new Node(messageList, answersForCurrentNode);
        answersForCurrentNode.clear();
        messageList.clear();

        //Ending2
        message1 = new NodeMessage(Messagetype.Text, "Beim Versuch die Frau zu beruhigen wurde Frau Müller hysterisch und schlug den Druiden gegen die Wand, sodass er beschädigt wurde und die Verbindung abbrach. Während ein Neustart versucht wurde, hat die Frau alle Beweise beseitigt und einen Brand gelegt. So konnte der Mord und das Motiv nicht aufgeklärt werden.", "");
        messageList.add(message1);
        ending2 = new Node(messageList, answersForCurrentNode);
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
