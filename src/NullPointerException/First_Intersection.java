package NullPointerException;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class First_Intersection {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "First Intersection";

        pn.NetworkPort = 1080;

        // -------------------------------------------------------------------
        // -------------------------------Lane1--------------------------------
        // --------------------------------------------------------------------

        DataCar p4 = new DataCar();
        p4.SetName("P4");
        pn.PlaceList.add(p4);

        DataCarQueue p9 = new DataCarQueue();
        p9.Value.Size = 3;
        p9.SetName("P9");
        pn.PlaceList.add(p9);

        DataString p11 = new DataString();
        p11.SetName("P11");
        pn.PlaceList.add(p11);

        DataCar p10 = new DataCar();
        p10.SetName("P10");
        pn.PlaceList.add(p10);

        // -------------------------------------------------------------------
        // -------------------------------Lane2--------------------------------
        // --------------------------------------------------------------------

        DataCar p12 = new DataCar();
        p12.SetName("P12");
        pn.PlaceList.add(p12);

        DataCarQueue p13 = new DataCarQueue();
        p13.Value.Size = 3;
        p13.SetName("P13");
        pn.PlaceList.add(p13);

        DataString p15 = new DataString();
        p15.SetName("P15");
        pn.PlaceList.add(p15);

        DataCar p14 = new DataCar();
        p14.SetName("P14");
        pn.PlaceList.add(p14);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 1-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue p21 = new DataCarQueue(); //p17.Printable = false;
        p21.Value.Size = 3;
        p21.SetName("P_o1");
        pn.PlaceList.add(p21);


        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 2-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue p22 = new DataCarQueue(); //p17.Printable = false;
        p22.Value.Size = 3;
        p22.SetName("P_o2");
        pn.PlaceList.add(p22);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 3-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue p20 = new DataCarQueue(); //p17.Printable = false;
        p20.Value.Size = 3;
        p20.SetName("P_o3");
        pn.PlaceList.add(p20);

        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue p0 = new DataCarQueue();
        p0.Value.Size = 3;
        p0.SetName("P_I");
        pn.PlaceList.add(p0);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T_u1";
        t1.InputPlaceName.add("P4");
        t1.InputPlaceName.add("P9");

        Condition T1Ct1 = new Condition(t1, "P4", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "P9", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        Condition Tu1Ct1 = new Condition(t1, "P4", TransitionCondition.NotNull);
        Condition Tu1Ct12 = new Condition(t1, "P9", TransitionCondition.CanNotAddCars);
        Tu1Ct1.SetNextCondition(LogicConnector.AND, Tu1Ct12);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P4", TransitionOperation.AddElement, "P9"));
        t1.GuardMappingList.add(grdT1);

        GuardMapping grdTu1 = new GuardMapping();
        grdTu1.condition = Tu1Ct1;
        grdTu1.Activations.add(new Activation(t1, "P9", TransitionOperation.Copy, "P9"));
        t1.GuardMappingList.add(grdTu1);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("P9");
        t2.InputPlaceName.add("P11");

        Condition T2Ct1 = new Condition(t2, "P11", TransitionCondition.Equal, "green");
        Condition T2Ct2 = new Condition(t2, "P9", TransitionCondition.HaveCar);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P9", TransitionOperation.PopElementWithoutTarget, "P10"));
        grdT2.Activations.add(new Activation(t2, "P11", TransitionOperation.Move, "P11"));

        t2.GuardMappingList.add(grdT2);
        t2.Delay = 0;
        pn.Transitions.add(t2);

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T_u2";
        t3.InputPlaceName.add("P12");
        t3.InputPlaceName.add("P13");

        Condition T3Ct1 = new Condition(t3, "P12", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t3, "P13", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        Condition Tu2Ct1 = new Condition(t3, "P12", TransitionCondition.NotNull);
        Condition Tu2Ct12 = new Condition(t3, "P13", TransitionCondition.CanNotAddCars);
        Tu2Ct1.SetNextCondition(LogicConnector.AND, Tu2Ct12);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P12", TransitionOperation.AddElement, "P13"));
        t3.GuardMappingList.add(grdT3);

        GuardMapping grdTu2 = new GuardMapping();
        grdTu2.condition = Tu2Ct1;
        grdTu2.Activations.add(new Activation(t3, "P13", TransitionOperation.Copy, "P13"));
        t3.GuardMappingList.add(grdTu2);

        t3.Delay = 0;
        pn.Transitions.add(t3);

        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("P13");
        t4.InputPlaceName.add("P15");

        Condition T4Ct1 = new Condition(t4, "P15", TransitionCondition.Equal, "green");
        Condition T4Ct2 = new Condition(t4, "P13", TransitionCondition.HaveCar);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "P13", TransitionOperation.PopElementWithoutTarget, "P14"));
        grdT4.Activations.add(new Activation(t4, "P15", TransitionOperation.Move, "P15"));

        t4.GuardMappingList.add(grdT4);
        t4.Delay = 0;
        pn.Transitions.add(t4);

        // --------------------------------------firstpart-------------------------------------------

        // T2_in ------------------------------------------------
        PetriTransition t2_in = new PetriTransition(pn);
        t2_in.TransitionName = "T_i1";
        t2_in.InputPlaceName.add("P10");
        t2_in.InputPlaceName.add("P_I");

        Condition T2_inCt1 = new Condition(t2_in, "P10", TransitionCondition.NotNull);
        Condition T2_inCt2 = new Condition(t2_in, "P_I", TransitionCondition.CanAddCars);
        T2_inCt1.SetNextCondition(LogicConnector.AND, T2_inCt2);

        GuardMapping grdT2_in = new GuardMapping();
        grdT2_in.condition = T2_inCt1;
        grdT2_in.Activations.add(new Activation(t2_in, "P10", TransitionOperation.AddElement, "P_I"));
        t2_in.GuardMappingList.add(grdT2_in);

        t2_in.Delay = 0;
        pn.Transitions.add(t2_in);

        // T10_out-----------------------------------------------------------
        PetriTransition t10_out = new PetriTransition(pn);
        t10_out.TransitionName = "T_g1";
        t10_out.InputPlaceName.add("P_I");
        t10_out.InputPlaceName.add("P_o1");

        Condition T10_outCt1 = new Condition(t10_out, "P_I", TransitionCondition.HaveCarForMe);
        Condition T10_outCt2 = new Condition(t10_out, "P_o1", TransitionCondition.CanAddCars);
        T10_outCt1.SetNextCondition(LogicConnector.AND, T10_outCt2);

        GuardMapping grdT10_out = new GuardMapping();
        grdT10_out.condition = T10_outCt1;
        grdT10_out.Activations.add(new Activation(t10_out, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o1"));
        t10_out.GuardMappingList.add(grdT10_out);

        t10_out.Delay = 0;
        pn.Transitions.add(t10_out);

        // --------------------------------------secondpart-------------------------------------------

        // T5_in ------------------------------------------------
        PetriTransition t5_in = new PetriTransition(pn);
        t5_in.TransitionName = "T_i2";
        t5_in.InputPlaceName.add("P14");
        t5_in.InputPlaceName.add("P_I");

        Condition T5_inCt1 = new Condition(t5_in, "P14", TransitionCondition.NotNull);
        Condition T5_inCt2 = new Condition(t5_in, "P_I", TransitionCondition.CanAddCars);
        T5_inCt1.SetNextCondition(LogicConnector.AND, T5_inCt2);

        GuardMapping grdT5_in = new GuardMapping();
        grdT5_in.condition = T5_inCt1;
        grdT5_in.Activations.add(new Activation(t5_in, "P14", TransitionOperation.AddElement, "P_I"));
        t5_in.GuardMappingList.add(grdT5_in);

        t5_in.Delay = 0;
        pn.Transitions.add(t5_in);

        // T11_out-----------------------------------------------------------
        PetriTransition t11_out = new PetriTransition(pn);
        t11_out.TransitionName = "T_g2";
        t11_out.InputPlaceName.add("P_I");
        t11_out.InputPlaceName.add("P_o2");

        Condition T11_outCt1 = new Condition(t11_out, "P_I", TransitionCondition.HaveCarForMe);
        Condition T11_outCt2 = new Condition(t11_out, "P_o2", TransitionCondition.CanAddCars);
        T11_outCt1.SetNextCondition(LogicConnector.AND, T11_outCt2);

        GuardMapping grdT11_out = new GuardMapping();
        grdT11_out.condition = T11_outCt1;
        grdT11_out.Activations.add(new Activation(t11_out, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o2"));
        t11_out.GuardMappingList.add(grdT11_out);

        t11_out.Delay = 0;
        pn.Transitions.add(t11_out);

        // -------------------------------------------------------------------------------------
        // ----------------------------PNStart-------------------------------------------------
        // -------------------------------------------------------------------------------------

        System.out.println("First Intersection started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
