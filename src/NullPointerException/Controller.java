package NullPointerException;

import Components.*;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller";
        pn.SetName("Controller");
        pn.NetworkPort = 1082;

        DataString ini = new DataString();
        //ini.Printable = false;
        ini.SetName("ini");
        ini.SetValue("red");
        pn.ConstantPlaceList.add(ini);

        DataString red = new DataString();
        //red.Printable = false;
        red.SetName("red");
        red.SetValue("red");
        pn.ConstantPlaceList.add(red);

        DataString green = new DataString();
        //green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString yellow = new DataString();
        //yellow.Printable = false;
        yellow.SetName("yellow");
        yellow.SetValue("yellow");
        pn.ConstantPlaceList.add(yellow);

        DataString p1 = new DataString();
        p1.SetName("r1r2r3r4r5r6r7");
        p1.SetValue("signal");
        pn.PlaceList.add(p1);

        DataString p2 = new DataString();
        p2.SetName("g1r2r3r4r5r6r7");
        pn.PlaceList.add(p2);

        DataString p3 = new DataString();
        p3.SetName("y1r2r3r4r5r6r7");
        pn.PlaceList.add(p3);

        DataString p4 = new DataString();
        p4.SetName("r1g2r3r4r5r6r7");
        pn.PlaceList.add(p4);

        DataString p5 = new DataString();
        p5.SetName("r1y2r3r4r5r6r7");
        pn.PlaceList.add(p5);

        DataString p6 = new DataString();
        p6.SetName("r1r2g3r4r5r6r7");
        pn.PlaceList.add(p6);

        DataString p7 = new DataString();
        p7.SetName("r1r2y3r4r5r6r7");
        pn.PlaceList.add(p7);

        DataString p8 = new DataString();
        p8.SetName("r1r2r3g4r5r6r7");
        pn.PlaceList.add(p8);

        DataString p9 = new DataString();
        p9.SetName("r1r2r3y4r5r6r7");
        pn.PlaceList.add(p9);

        DataString p10 = new DataString();
        p10.SetName("r1r2r3r4g5r6r7");
        pn.PlaceList.add(p10);

        DataString p11 = new DataString();
        p11.SetName("r1r2r3r4y5r6r7");
        pn.PlaceList.add(p11);

        DataString p12 = new DataString();
        p12.SetName("r1r2r3r4r5g6r7");
        pn.PlaceList.add(p12);

        DataString p13 = new DataString();
        p13.SetName("r1r2r3r4r5y6r7");
        pn.PlaceList.add(p13);

        DataString p14 = new DataString();
        p14.SetName("r1r2r3r4r5r6g7");
        pn.PlaceList.add(p14);

        DataString p15 = new DataString();
        p15.SetName("r1r2r3r4r5r6y7");
        pn.PlaceList.add(p14);

        DataTransfer p16 = new DataTransfer();
        p16.SetName("OP1");
        p16.Value = new TransferOperation("localhost", "1080", "P_TL1");
        pn.PlaceList.add(p16);

        DataTransfer p17 = new DataTransfer();
        p17.SetName("OP2");
        p17.Value = new TransferOperation("localhost", "1080", "P_TL2");
        pn.PlaceList.add(p17);

        DataTransfer p18 = new DataTransfer();
        p18.SetName("OP3");
        p18.Value = new TransferOperation("localhost", "1081", "P_TL5");
        pn.PlaceList.add(p18);

        DataTransfer p19 = new DataTransfer();
        p19.SetName("OP4");
        p19.Value = new TransferOperation("localhost", "1081", "P_TL6");
        pn.PlaceList.add(p19);

        DataTransfer p20 = new DataTransfer();
        p20.SetName("OP5");
        p20.Value = new TransferOperation("localhost", "1081", "P_TL7");
        pn.PlaceList.add(p20);

        DataTransfer p21 = new DataTransfer();
        p21.SetName("OP6");
        p21.Value = new TransferOperation("localhost", "1081", "P_TL3");
        pn.PlaceList.add(p21);

        DataTransfer p22 = new DataTransfer();
        p22.SetName("OP7");
        p22.Value = new TransferOperation("localhost", "1081", "P_TL4");
        pn.PlaceList.add(p22);

        //----------------------------iniT------------------------------------
        PetriTransition iniT = new PetriTransition(pn);
        iniT.TransitionName = "iniT";

        Condition iniTCt1 = new Condition(iniT, "ini", TransitionCondition.NotNull);

        GuardMapping grdiniT = new GuardMapping();
        grdiniT.condition = iniTCt1;

        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP1"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP2"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP3"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP4"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP5"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP6"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP7"));
        grdiniT.Activations.add(new Activation(iniT, "", TransitionOperation.MakeNull, "ini"));

        iniT.GuardMappingList.add(grdiniT);

        iniT.Delay = 5;
        pn.Transitions.add(iniT);

        //----------------------------T1------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("r1r2r3r4r5r6r7");


        Condition T1Ct1 = new Condition(t1, "r1r2r3r4r5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "r1r2r3r4r5r6r7", TransitionOperation.Move, "g1r2r3r4r5r6r7"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 5;
        pn.Transitions.add(t1);

        //----------------------------T2------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("g1r2r3r4r5r6r7");

        Condition T2Ct1 = new Condition(t2, "g1r2r3r4r5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT21 = new GuardMapping();
        grdT21.condition = T2Ct1;
        grdT21.Activations.add(new Activation(t2, "g1r2r3r4r5r6r7", TransitionOperation.Move, "y1r2r3r4r5r6r7"));
        grdT21.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));

        t2.GuardMappingList.add(grdT21);

        t2.Delay = 5;
        pn.Transitions.add(t2);

        //----------------------------T3------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("y1r2r3r4r5r6r7");


        Condition T3Ct1 = new Condition(t3, "y1r2r3r4r5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "y1r2r3r4r5r6r7", TransitionOperation.Move, "r1g2r3r4r5r6r7"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
        grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP2"));

        t3.GuardMappingList.add(grdT3);

        t3.Delay = 5;
        pn.Transitions.add(t3);

        //----------------------------T4------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("r1g2r3r4r5r6r7");


        Condition T4Ct1 = new Condition(t4, "r1g2r3r4r5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "r1g2r3r4r5r6r7", TransitionOperation.Move, "r1y2r3r4r5r6r7"));
        grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));

        t4.GuardMappingList.add(grdT4);

        t4.Delay = 5;
        pn.Transitions.add(t4);

        //----------------------------T5------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("r1y2r3r4r5r6r7");


        Condition T5Ct1 = new Condition(t5, "r1y2r3r4r5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5, "r1y2r3r4r5r6r7", TransitionOperation.Move, "r1r2g3r4r5r6r7"));
        grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP2"));
        grdT5.Activations.add(new Activation(t5, "green", TransitionOperation.SendOverNetwork, "OP3"));

        t5.GuardMappingList.add(grdT5);

        t5.Delay = 5;
        pn.Transitions.add(t5);

        //----------------------------T6------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("r1r2g3r4r5r6r7");


        Condition T6Ct1 = new Condition(t6, "r1r2g3r4r5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t6, "r1r2g3r4r5r6r7", TransitionOperation.Move, "r1r2y3r4r5r6r7"));
        grdT6.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));

        t6.GuardMappingList.add(grdT6);

        t6.Delay = 5;
        pn.Transitions.add(t6);

        //----------------------------T7------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("r1r2y3r4r5r6r7");


        Condition T7Ct1 = new Condition(t7, "r1r2y3r4r5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;
        grdT7.Activations.add(new Activation(t7, "r1r2y3r4r5r6r7", TransitionOperation.Move, "r1r2r3g4r5r6r7"));
        grdT7.Activations.add(new Activation(t7, "red", TransitionOperation.SendOverNetwork, "OP3"));
        grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP4"));

        t7.GuardMappingList.add(grdT7);

        t7.Delay = 5;
        pn.Transitions.add(t7);

        //----------------------------T8------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("r1r2r3g4r5r6r7");


        Condition T8Ct1 = new Condition(t8, "r1r2r3g4r5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;
        grdT8.Activations.add(new Activation(t8, "r1r2r3g4r5r6r7", TransitionOperation.Move, "r1r2r3y4r5r6r7"));
        grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP4"));

        t8.GuardMappingList.add(grdT8);

        t8.Delay = 5;
        pn.Transitions.add(t8);

        //----------------------------T9------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T9";
        t9.InputPlaceName.add("r1r2r3y4r5r6r7");


        Condition T9Ct1 = new Condition(t9, "r1r2r3y4r5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition = T9Ct1;
        grdT9.Activations.add(new Activation(t9, "r1r2r3y4r5r6r7", TransitionOperation.Move, "r1r2r3r4g5r6r7"));
        grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.SendOverNetwork, "OP4"));
        grdT9.Activations.add(new Activation(t9, "green", TransitionOperation.SendOverNetwork, "OP5"));

        t9.GuardMappingList.add(grdT9);

        t9.Delay = 5;
        pn.Transitions.add(t9);

        //----------------------------T10------------------------------------
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "T10";
        t10.InputPlaceName.add("r1r2r3r4g5r6r7");


        Condition T10Ct1 = new Condition(t10, "r1r2r3r4g5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;
        grdT10.Activations.add(new Activation(t10, "r1r2r3r4g5r6r7", TransitionOperation.Move, "r1r2r3r4y5r6r7"));
        grdT10.Activations.add(new Activation(t10, "yellow", TransitionOperation.SendOverNetwork, "OP5"));

        t10.GuardMappingList.add(grdT10);

        t10.Delay = 5;
        pn.Transitions.add(t10);

        //----------------------------T11------------------------------------
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "T11";
        t11.InputPlaceName.add("r1r2r3r4y5r6r7");


        Condition T11Ct1 = new Condition(t11, "r1r2r3r4y5r6r7", TransitionCondition.NotNull);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;
        grdT11.Activations.add(new Activation(t11, "r1r2r3r4y5r6r7", TransitionOperation.Move, "r1r2r3r4r5g6r7"));
        grdT11.Activations.add(new Activation(t11, "red", TransitionOperation.SendOverNetwork, "OP5"));
        grdT11.Activations.add(new Activation(t11, "green", TransitionOperation.SendOverNetwork, "OP6"));

        t11.GuardMappingList.add(grdT11);

        t11.Delay = 5;
        pn.Transitions.add(t11);

        //----------------------------T12------------------------------------
        PetriTransition t12 = new PetriTransition(pn);
        t12.TransitionName = "T12";
        t12.InputPlaceName.add("r1r2r3r4r5g6r7");


        Condition T12Ct1 = new Condition(t12, "r1r2r3r4r5g6r7", TransitionCondition.NotNull);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;
        grdT12.Activations.add(new Activation(t12, "r1r2r3r4r5g6r7", TransitionOperation.Move, "r1r2r3r4r5y6r7"));
        grdT12.Activations.add(new Activation(t12, "yellow", TransitionOperation.SendOverNetwork, "OP6"));

        t12.GuardMappingList.add(grdT12);

        t12.Delay = 5;
        pn.Transitions.add(t12);

        //----------------------------T13------------------------------------
        PetriTransition t13 = new PetriTransition(pn);
        t13.TransitionName = "T13";
        t13.InputPlaceName.add("r1r2r3r4r5y6r7");


        Condition T13Ct1 = new Condition(t13, "r1r2r3r4r5y6r7", TransitionCondition.NotNull);

        GuardMapping grdT13 = new GuardMapping();
        grdT13.condition = T13Ct1;
        grdT13.Activations.add(new Activation(t13, "r1r2r3r4r5y6r7", TransitionOperation.Move, "r1r2r3r4r5r6g7"));
        grdT13.Activations.add(new Activation(t13, "red", TransitionOperation.SendOverNetwork, "OP6"));
        grdT13.Activations.add(new Activation(t13, "green", TransitionOperation.SendOverNetwork, "OP7"));

        t13.GuardMappingList.add(grdT13);

        t13.Delay = 5;
        pn.Transitions.add(t13);

        //----------------------------T14------------------------------------
        PetriTransition t14 = new PetriTransition(pn);
        t14.TransitionName = "T14";
        t14.InputPlaceName.add("r1r2r3r4r5r6g7");


        Condition T14Ct1 = new Condition(t14, "r1r2r3r4r5r6g7", TransitionCondition.NotNull);

        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;
        grdT14.Activations.add(new Activation(t14, "r1r2r3r4r5r6g7", TransitionOperation.Move, "r1r2r3r4r5r6y7"));
        grdT14.Activations.add(new Activation(t14, "yellow", TransitionOperation.SendOverNetwork, "OP7"));

        t14.GuardMappingList.add(grdT14);

        t14.Delay = 5;
        pn.Transitions.add(t14);

        //----------------------------T15------------------------------------
        PetriTransition t15 = new PetriTransition(pn);
        t15.TransitionName = "T15";
        t15.InputPlaceName.add("r1r2r3r4r5r6y7");


        Condition T15Ct1 = new Condition(t15, "r1r2r3r4r5r6y7", TransitionCondition.NotNull);

        GuardMapping grdT15 = new GuardMapping();
        grdT15.condition = T15Ct1;
        grdT15.Activations.add(new Activation(t15, "r1r2r3r4r5r6y7", TransitionOperation.Move, "r1r2r3r4r5r6r7"));
        grdT15.Activations.add(new Activation(t15, "red", TransitionOperation.SendOverNetwork, "OP7"));

        t15.GuardMappingList.add(grdT15);

        t15.Delay = 5;
        pn.Transitions.add(t15);

        // -------------------------------------------------------------------------------------
        // ----------------------------PN Start-------------------------------------------------
        // -------------------------------------------------------------------------------------

        System.out.println("Controller started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

    }
}
