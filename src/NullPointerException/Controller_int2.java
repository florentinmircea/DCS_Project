package NullPointerException;

import Components.*;
import DataObjects.DataFloat;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

import java.util.ArrayList;

public class Controller_int2 {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller intersection 2";
        pn.SetName("Controller intersection 2");
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
        p1.SetName("r1r2r3r4");
        p1.SetValue("signal");
        pn.PlaceList.add(p1);

        DataString p2 = new DataString();
        p2.SetName("g1r2r3r4");
        pn.PlaceList.add(p2);

        DataString p3 = new DataString();
        p3.SetName("y1r2r3r4");
        pn.PlaceList.add(p3);

        DataString p4 = new DataString();
        p4.SetName("r1g2r3r4");
        pn.PlaceList.add(p4);

        DataString p5 = new DataString();
        p5.SetName("r1y2r3r4");
        pn.PlaceList.add(p5);

        DataString p6 = new DataString();
        p6.SetName("r1r2g3r4");
        pn.PlaceList.add(p6);

        DataString p7 = new DataString();
        p7.SetName("r1r2y3r4");
        pn.PlaceList.add(p7);

        DataString p8 = new DataString();
        p8.SetName("r1r2r3g4");
        pn.PlaceList.add(p8);

        DataString p9 = new DataString();
        p9.SetName("r1r2r3y4");
        pn.PlaceList.add(p9);

        DataString in3 = new DataString();
        in3.SetName("in3");
        pn.PlaceList.add(in3);

        DataString in4 = new DataString();
        in4.SetName("in4");
        pn.PlaceList.add(in4);

        DataString in5 = new DataString();
        in5.SetName("in5");
        pn.PlaceList.add(in5);

        DataString in6 = new DataString();
        in6.SetName("in6");
        pn.PlaceList.add(in6);

        DataString PlusTL1 = new DataString();
        PlusTL1.SetName("PlusTL1");
        pn.PlaceList.add(PlusTL1);

        DataString PlusTL2 = new DataString();
        PlusTL2.SetName("PlusTL2");
        pn.PlaceList.add(PlusTL2);

        DataString PlusTL3 = new DataString();
        PlusTL3.SetName("PlusTL3");
        pn.PlaceList.add(PlusTL3);

        DataString PlusTL4 = new DataString();
        PlusTL4.SetName("PlusTL4");
        pn.PlaceList.add(PlusTL4);

        DataFloat counter1 = new DataFloat();
        counter1.SetName("counter1");
        counter1.SetValue(3.0f);
        pn.PlaceList.add(counter1);

        DataFloat counter2 = new DataFloat();
        counter2.SetName("counter2");
        counter2.SetValue(3.0f);
        pn.PlaceList.add(counter2);

        DataFloat counter3 = new DataFloat();
        counter3.SetName("counter3");
        counter3.SetValue(3.0f);
        pn.PlaceList.add(counter3);

        DataFloat counter4 = new DataFloat();
        counter4.SetName("counter4");
        counter4.SetValue(3.0f);
        pn.PlaceList.add(counter4);

        DataFloat zero = new DataFloat();
        zero.SetName("zero");
        zero.SetValue(0);
        pn.ConstantPlaceList.add(zero);

        DataFloat initialValue = new DataFloat();
        initialValue.SetName("initialValue");
        initialValue.SetValue(3);
        pn.ConstantPlaceList.add(initialValue);

        DataFloat constantValue = new DataFloat();
        constantValue.SetName("constantValue");
        constantValue.SetValue(1);
        pn.ConstantPlaceList.add(constantValue);

        DataTransfer p10 = new DataTransfer();
        p10.SetName("OP1");
        p10.Value = new TransferOperation("localhost", "1080", "P_TL5");
        pn.PlaceList.add(p10);

        DataTransfer p11 = new DataTransfer();
        p11.SetName("OP2");
        p11.Value = new TransferOperation("localhost", "1080", "P_TL6");
        pn.PlaceList.add(p11);

        DataTransfer p12 = new DataTransfer();
        p12.SetName("OP3");
        p12.Value = new TransferOperation("localhost", "1080", "P_TL7");
        pn.PlaceList.add(p12);

        DataTransfer p13 = new DataTransfer();
        p13.SetName("OP4");
        p13.Value = new TransferOperation("localhost", "1080", "P_TL3");
        pn.PlaceList.add(p13);


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
        grdiniT.Activations.add(new Activation(iniT, "", TransitionOperation.MakeNull, "ini"));

        iniT.GuardMappingList.add(grdiniT);

        iniT.Delay = 5;
        pn.Transitions.add(iniT);


        //----------------------------T1------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("r1r2r3r4");


        Condition T1Ct1 = new Condition(t1, "r1r2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "r1r2r3r4", TransitionOperation.Move, "g1r2r3r4"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 5;
        pn.Transitions.add(t1);

        //----------------------------T2------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("g1r2r3r4");
        t2.InputPlaceName.add("in3");
        t2.InputPlaceName.add("counter1");


        Condition T2Ct1 = new Condition(t2, "in3", TransitionCondition.IsNull);
        Condition T2Ct2 = new Condition(t2, "g1r2r3r4", TransitionCondition.NotNull);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT21 = new GuardMapping();
        grdT21.condition = T2Ct1;
        grdT21.Activations.add(new Activation(t2, "g1r2r3r4", TransitionOperation.Move, "y1r2r3r4"));
        grdT21.Activations.add(new Activation(t2, "counter1", TransitionOperation.Move, "counter1"));
        grdT21.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));

        t2.GuardMappingList.add(grdT21);

        Condition T2Ct3 = new Condition(t2, "in3", TransitionCondition.NotNull);
        Condition T2Ct4 = new Condition(t2, "counter1", TransitionCondition.MoreThan, "zero");
        Condition T2Ct5 = new Condition(t2, "g1r2r3r4", TransitionCondition.NotNull);
        T2Ct3.SetNextCondition(LogicConnector.AND, T2Ct4);
        T2Ct4.SetNextCondition(LogicConnector.AND, T2Ct5);

        GuardMapping grdT22 = new GuardMapping();
        grdT22.condition = T2Ct3;
        grdT22.Activations.add(new Activation(t2, "PlusTL1", TransitionOperation.Move, "g1r2r3r4"));
        ArrayList<String> list = new ArrayList<String>();
        list.add("counter1");
        list.add("constantValue");
        grdT22.Activations.add(new Activation(t2, list, TransitionOperation.Sub, "counter1"));

        t2.GuardMappingList.add(grdT22);

        Condition T2Ct6 = new Condition(t2, "counter1", TransitionCondition.Equal,"zero");
        Condition T2Ct7 = new Condition(t2, "g1r2r3r4", TransitionCondition.NotNull);
        T2Ct6.SetNextCondition(LogicConnector.AND, T2Ct7);

        GuardMapping grdT23 = new GuardMapping();
        grdT23.condition = T2Ct6;
        grdT23.Activations.add(new Activation(t2, "g1r2r3r4", TransitionOperation.Move, "y1r2r3r4"));
        grdT23.Activations.add(new Activation(t2, "initialValue", TransitionOperation.Move, "counter1"));
        grdT23.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));

        t2.GuardMappingList.add(grdT23);

        t2.Delay = 5;
        pn.Transitions.add(t2);


        //----------------------------t1Plus------------------------------------
        PetriTransition t1Plus = new PetriTransition(pn);
        t1Plus.TransitionName = "t1Plus";
        t1Plus.InputPlaceName.add("PlusTL1");

        Condition T1pCt1 = new Condition(t1Plus, "PlusTL1", TransitionCondition.NotNull);

        GuardMapping grdT1p = new GuardMapping();
        grdT1p.condition = T1pCt1;
        grdT1p.Activations.add(new Activation(t1Plus, "PlusTL1", TransitionOperation.Move, "g1r2r3r4"));

        t1Plus.GuardMappingList.add(grdT1p);

        t1Plus.Delay = 0;
        pn.Transitions.add(t1Plus);


        //----------------------------T3------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("y1r2r3r4");


        Condition T3Ct1 = new Condition(t3, "y1r2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "y1r2r3r4", TransitionOperation.Move, "r1g2r3r4"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
        //grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP3"));
        grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP2"));
        //grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP4"));

        t3.GuardMappingList.add(grdT3);

        t3.Delay = 5;
        pn.Transitions.add(t3);


        //----------------------------T4------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("r1g2r3r4");
        t4.InputPlaceName.add("in4");
        t4.InputPlaceName.add("counter2");


        Condition T4Ct1 = new Condition(t4, "in4", TransitionCondition.IsNull);
        Condition T4Ct2 = new Condition(t4, "r1g2r3r4", TransitionCondition.NotNull);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT41 = new GuardMapping();
        grdT41.condition = T4Ct1;
        grdT41.Activations.add(new Activation(t4, "r1g2r3r4", TransitionOperation.Move, "r1y2r3r4"));
        grdT41.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
        grdT41.Activations.add(new Activation(t4, "counter2", TransitionOperation.Move, "counter2"));

        t4.GuardMappingList.add(grdT41);

        Condition T4Ct3 = new Condition(t4, "in4", TransitionCondition.NotNull);
        Condition T4Ct4 = new Condition(t4, "counter2", TransitionCondition.MoreThan, "zero");
        Condition T4Ct5 = new Condition(t4, "r1g2r3r4", TransitionCondition.NotNull);
        T4Ct3.SetNextCondition(LogicConnector.AND, T4Ct4);
        T4Ct4.SetNextCondition(LogicConnector.AND, T4Ct5);

        GuardMapping grdT42 = new GuardMapping();
        grdT42.condition = T4Ct3;
        grdT42.Activations.add(new Activation(t4, "PlusTL2", TransitionOperation.Move, "r1g2r3r4"));
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("counter2");
        list2.add("constantValue");
        grdT42.Activations.add(new Activation(t4, list2, TransitionOperation.Sub, "counter2"));

        t4.GuardMappingList.add(grdT42);

        Condition T4Ct6 = new Condition(t4, "counter2", TransitionCondition.Equal,"zero");
        Condition T4Ct7 = new Condition(t4, "r1g2r3r4", TransitionCondition.NotNull);
        T4Ct6.SetNextCondition(LogicConnector.AND, T4Ct7);

        GuardMapping grdT43 = new GuardMapping();
        grdT43.condition = T4Ct6;
        grdT43.Activations.add(new Activation(t4, "r1g2r3r4", TransitionOperation.Move, "r1y2r3r4"));
        grdT43.Activations.add(new Activation(t4, "initialValue", TransitionOperation.Move, "counter2"));
        grdT43.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));

        t4.GuardMappingList.add(grdT43);

        t4.Delay = 5;
        pn.Transitions.add(t4);


        //----------------------------t2Plus------------------------------------
        PetriTransition t2Plus = new PetriTransition(pn);
        t2Plus.TransitionName = "t2Plus";
        t2Plus.InputPlaceName.add("PlusTL2");

        Condition T2pCt1 = new Condition(t2Plus, "PlusTL2", TransitionCondition.NotNull);

        GuardMapping grdT2p = new GuardMapping();
        grdT2p.condition = T2pCt1;
        grdT2p.Activations.add(new Activation(t2Plus, "PlusTL2", TransitionOperation.Move, "r1g2r3r4"));

        t2Plus.GuardMappingList.add(grdT2p);

        t2Plus.Delay = 0;
        pn.Transitions.add(t2Plus);


        //----------------------------T5------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("r1y2r3r4");


        Condition T5Ct1 = new Condition(t5, "r1y2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5, "r1y2r3r4", TransitionOperation.Move, "r1r2g3r4"));
        grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP2"));
        grdT5.Activations.add(new Activation(t5, "green", TransitionOperation.SendOverNetwork, "OP3"));


        t5.GuardMappingList.add(grdT5);

        t5.Delay = 5;
        pn.Transitions.add(t5);


        //----------------------------T6------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("r1r2g3r4");
        t6.InputPlaceName.add("in5");
        t6.InputPlaceName.add("counter3");


        Condition T6Ct1 = new Condition(t4, "in5", TransitionCondition.IsNull);
        Condition T6Ct2 = new Condition(t6, "r1r2g3r4", TransitionCondition.NotNull);
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT61 = new GuardMapping();
        grdT61.condition = T6Ct1;
        grdT61.Activations.add(new Activation(t6, "r1r2g3r4", TransitionOperation.Move, "r1r2y3r4"));
        grdT61.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));
        grdT61.Activations.add(new Activation(t6, "counter3", TransitionOperation.Move, "counter3"));

        t6.GuardMappingList.add(grdT61);

        Condition T6Ct3 = new Condition(t6, "in5", TransitionCondition.NotNull);
        Condition T6Ct4 = new Condition(t6, "counter3", TransitionCondition.MoreThan, "zero");
        Condition T6Ct5 = new Condition(t6, "r1r2g3r4", TransitionCondition.NotNull);
        T6Ct3.SetNextCondition(LogicConnector.AND, T6Ct4);
        T6Ct4.SetNextCondition(LogicConnector.AND, T6Ct5);

        GuardMapping grdT62 = new GuardMapping();
        grdT62.condition = T6Ct3;
        grdT62.Activations.add(new Activation(t6, "PlusTL3", TransitionOperation.Move, "r1r2g3r4"));
        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("counter3");
        list3.add("constantValue");
        grdT62.Activations.add(new Activation(t6, list3, TransitionOperation.Sub, "counter3"));

        t6.GuardMappingList.add(grdT62);

        Condition T6Ct6 = new Condition(t6, "counter3", TransitionCondition.Equal,"zero");
        Condition T6Ct7 = new Condition(t6, "r1r2g3r4", TransitionCondition.NotNull);
        T6Ct6.SetNextCondition(LogicConnector.AND, T6Ct7);

        GuardMapping grdT63 = new GuardMapping();
        grdT63.condition = T6Ct6;
        grdT63.Activations.add(new Activation(t6, "r1r2g3r4", TransitionOperation.Move, "r1r2y3r4"));
        grdT63.Activations.add(new Activation(t6, "initialValue", TransitionOperation.Move, "counter3"));
        grdT63.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));

        t6.GuardMappingList.add(grdT63);

        t6.Delay = 5;
        pn.Transitions.add(t6);


        //----------------------------t3Plus------------------------------------
        PetriTransition t3Plus = new PetriTransition(pn);
        t3Plus.TransitionName = "t3Plus";
        t3Plus.InputPlaceName.add("PlusTL3");

        Condition T3pCt1 = new Condition(t3Plus, "PlusTL3", TransitionCondition.NotNull);

        GuardMapping grdT3p = new GuardMapping();
        grdT3p.condition = T3pCt1;
        grdT3p.Activations.add(new Activation(t3Plus, "PlusTL3", TransitionOperation.Move, "r1r2g3r4"));

        t3Plus.GuardMappingList.add(grdT3p);

        t3Plus.Delay = 0;
        pn.Transitions.add(t3Plus);


        //----------------------------T7------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("r1r2y3r4");


        Condition T7Ct1 = new Condition(t7, "r1r2y3r4", TransitionCondition.NotNull);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;
        grdT7.Activations.add(new Activation(t7, "r1r2y3r4", TransitionOperation.Move, "r1r2r3g4"));
        grdT7.Activations.add(new Activation(t7, "red", TransitionOperation.SendOverNetwork, "OP3"));
        grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP4"));


        t7.GuardMappingList.add(grdT7);

        t7.Delay = 5;
        pn.Transitions.add(t7);


        //----------------------------T8------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("r1r2r3g4");
        t8.InputPlaceName.add("in6");
        t8.InputPlaceName.add("counter4");

        Condition T8Ct1 = new Condition(t4, "in6", TransitionCondition.IsNull);
        Condition T8Ct2 = new Condition(t8, "r1r2r3g4", TransitionCondition.NotNull);
        T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT81 = new GuardMapping();
        grdT81.condition = T8Ct1;
        grdT81.Activations.add(new Activation(t8, "r1r2r3g4", TransitionOperation.Move, "r1r2r3y4"));
        grdT81.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP4"));
        grdT81.Activations.add(new Activation(t8, "counter4", TransitionOperation.Move, "counter4"));

        t8.GuardMappingList.add(grdT81);

        Condition T8Ct3 = new Condition(t8, "in6", TransitionCondition.NotNull);
        Condition T8Ct4 = new Condition(t8, "counter4", TransitionCondition.MoreThan, "zero");
        Condition T8Ct5 = new Condition(t8, "r1r2r3g4", TransitionCondition.NotNull);
        T8Ct3.SetNextCondition(LogicConnector.AND, T8Ct4);
        T8Ct4.SetNextCondition(LogicConnector.AND, T8Ct5);

        GuardMapping grdT82 = new GuardMapping();
        grdT82.condition = T8Ct3;
        grdT82.Activations.add(new Activation(t8, "PlusTL4", TransitionOperation.Move, "r1r2r3g4"));
        ArrayList<String> list4 = new ArrayList<String>();
        list4.add("counter4");
        list4.add("constantValue");
        grdT82.Activations.add(new Activation(t8, list4, TransitionOperation.Sub, "counter4"));

        t8.GuardMappingList.add(grdT82);

        Condition T8Ct6 = new Condition(t8, "counter4", TransitionCondition.Equal,"zero");
        Condition T8Ct7 = new Condition(t8, "r1r2r3g4", TransitionCondition.NotNull);
        T8Ct6.SetNextCondition(LogicConnector.AND, T8Ct7);

        GuardMapping grdT83 = new GuardMapping();
        grdT83.condition = T8Ct6;
        grdT83.Activations.add(new Activation(t8, "r1r2r3g4", TransitionOperation.Move, "r1r2r3y4"));
        grdT83.Activations.add(new Activation(t8, "initialValue", TransitionOperation.Move, "counter4"));
        grdT83.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP4"));

        t8.GuardMappingList.add(grdT83);

        t8.Delay = 5;
        pn.Transitions.add(t8);


        //----------------------------t4Plus------------------------------------
        PetriTransition t4Plus = new PetriTransition(pn);
        t4Plus.TransitionName = "t4Plus";
        t4Plus.InputPlaceName.add("PlusTL4");

        Condition T4pCt1 = new Condition(t4Plus, "PlusTL4", TransitionCondition.NotNull);

        GuardMapping grdT4p = new GuardMapping();
        grdT4p.condition = T4pCt1;
        grdT4p.Activations.add(new Activation(t4Plus, "PlusTL4", TransitionOperation.Move, "r1r2r3g4"));

        t4Plus.GuardMappingList.add(grdT4p);

        t4Plus.Delay = 0;
        pn.Transitions.add(t4Plus);


        //----------------------------T9------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T9";
        t9.InputPlaceName.add("r1r2r3y4");


        Condition T9Ct1 = new Condition(t9, "r1r2r3y4", TransitionCondition.NotNull);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition = T9Ct1;
        grdT9.Activations.add(new Activation(t9, "r1r2r3y4", TransitionOperation.Move, "r1r2r3r4"));
        grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.SendOverNetwork, "OP4"));


        t9.GuardMappingList.add(grdT9);

        t9.Delay = 5;
        pn.Transitions.add(t9);


        // -------------------------------------------------------------------------------------
        // ----------------------------PN Start-------------------------------------------------
        // -------------------------------------------------------------------------------------

        System.out.println("Exp1 started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
