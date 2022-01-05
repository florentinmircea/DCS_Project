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

        DataCar P_I1 = new DataCar();
        P_I1.SetName("P_I1");
        pn.PlaceList.add(P_I1);

        DataCarQueue P_I2 = new DataCarQueue();
        P_I2.Value.Size = 3;
        P_I2.SetName("P_I2");
        pn.PlaceList.add(P_I2);

        DataString P_TL1 = new DataString();
        P_TL1.SetName("P_TL1");
        pn.PlaceList.add(P_TL1);

        DataCar P_I3 = new DataCar();
        P_I3.SetName("P_I3");
        pn.PlaceList.add(P_I3);

        // -------------------------------------------------------------------
        // -------------------------------Lane2--------------------------------
        // --------------------------------------------------------------------

        DataCar P_I4 = new DataCar();
        P_I4.SetName("P_I4");
        pn.PlaceList.add(P_I4);

        DataCarQueue P_I5 = new DataCarQueue();
        P_I5.Value.Size = 3;
        P_I5.SetName("P_I5");
        pn.PlaceList.add(P_I5);

        DataString P_TL2 = new DataString();
        P_TL2.SetName("P_TL2");
        pn.PlaceList.add(P_TL2);

        DataCar P_I6 = new DataCar();
        P_I6.SetName("P_I6");
        pn.PlaceList.add(P_I6);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 1-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O1 = new DataCarQueue(); //p17.Printable = false;
        P_O1.Value.Size = 3;
        P_O1.SetName("P_O1");
        pn.PlaceList.add(P_O1);


        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 2-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O3 = new DataCarQueue(); //p17.Printable = false;
        P_O3.Value.Size = 3;
        P_O3.SetName("P_O3");
        pn.PlaceList.add(P_O3);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 3-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_O5 = new DataCarQueue(); //p17.Printable = false;
        P_O5.Value.Size = 3;
        P_O5.SetName("P_O5");
        pn.PlaceList.add(P_O5);

        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue P_INT1 = new DataCarQueue();
        P_INT1.Value.Size = 3;
        P_INT1.SetName("P_INT1");
        pn.PlaceList.add(P_INT1);

        // T_I1 ------------------------------------------------
        PetriTransition T_I1 = new PetriTransition(pn);
        T_I1.TransitionName = "T_I1";
        T_I1.InputPlaceName.add("P_I1");
        T_I1.InputPlaceName.add("P_I2");

        Condition T1Ct1 = new Condition(T_I1, "P_I1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(T_I1, "P_I2", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        Condition Tu1Ct1 = new Condition(T_I1, "P_I1", TransitionCondition.NotNull);
        Condition Tu1Ct12 = new Condition(T_I1, "P_I2", TransitionCondition.CanNotAddCars);
        Tu1Ct1.SetNextCondition(LogicConnector.AND, Tu1Ct12);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(T_I1, "P_I1", TransitionOperation.AddElement, "P_I2"));
        T_I1.GuardMappingList.add(grdT1);

        GuardMapping grdTu1 = new GuardMapping();
        grdTu1.condition = Tu1Ct1;
        grdTu1.Activations.add(new Activation(T_I1, "P_I2", TransitionOperation.Copy, "P_I2"));
        T_I1.GuardMappingList.add(grdTu1);

        T_I1.Delay = 0;
        pn.Transitions.add(T_I1);

        // T_I2 ------------------------------------------------
        PetriTransition T_I2 = new PetriTransition(pn);
        T_I2.TransitionName = "T_I2";
        T_I2.InputPlaceName.add("P_I2");
        T_I2.InputPlaceName.add("P_TL1");

        Condition T2Ct1 = new Condition(T_I2, "P_TL1", TransitionCondition.Equal, "green");
        Condition T2Ct2 = new Condition(T_I2, "P_I2", TransitionCondition.HaveCar);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(T_I2, "P_I2", TransitionOperation.PopElementWithoutTarget, "P_I3"));
        grdT2.Activations.add(new Activation(T_I2, "P_TL1", TransitionOperation.Move, "P_TL1"));

        T_I2.GuardMappingList.add(grdT2);
        T_I2.Delay = 0;
        pn.Transitions.add(T_I2);

        // T_I4 ------------------------------------------------
        PetriTransition T_I4 = new PetriTransition(pn);
        T_I4.TransitionName = "T_I4";
        T_I4.InputPlaceName.add("P_I4");
        T_I4.InputPlaceName.add("P_I5");

        Condition T3Ct1 = new Condition(T_I4, "P_I4", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(T_I4, "P_I5", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        Condition Tu2Ct1 = new Condition(T_I4, "P_I4", TransitionCondition.NotNull);
        Condition Tu2Ct12 = new Condition(T_I4, "P_I5", TransitionCondition.CanNotAddCars);
        Tu2Ct1.SetNextCondition(LogicConnector.AND, Tu2Ct12);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(T_I4, "P_I4", TransitionOperation.AddElement, "P_I5"));
        T_I4.GuardMappingList.add(grdT3);

        GuardMapping grdTu2 = new GuardMapping();
        grdTu2.condition = Tu2Ct1;
        grdTu2.Activations.add(new Activation(T_I4, "P_I5", TransitionOperation.Copy, "P_I5"));
        T_I4.GuardMappingList.add(grdTu2);

        T_I4.Delay = 0;
        pn.Transitions.add(T_I4);

        // T_I5 ------------------------------------------------
        PetriTransition T_I5 = new PetriTransition(pn);
        T_I5.TransitionName = "T_I5";
        T_I5.InputPlaceName.add("P_I5");
        T_I5.InputPlaceName.add("P_TL2");

        Condition T4Ct1 = new Condition(T_I5, "P_TL2", TransitionCondition.Equal, "green");
        Condition T4Ct2 = new Condition(T_I5, "P_I5", TransitionCondition.HaveCar);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(T_I5, "P_I5", TransitionOperation.PopElementWithoutTarget, "P_I6"));
        grdT4.Activations.add(new Activation(T_I5, "P_TL2", TransitionOperation.Move, "P_TL2"));

        T_I5.GuardMappingList.add(grdT4);
        T_I5.Delay = 0;
        pn.Transitions.add(T_I5);

        // --------------------------------------firstpart-------------------------------------------

        // T_I3 ------------------------------------------------
        PetriTransition T_I3 = new PetriTransition(pn);
        T_I3.TransitionName = "T_I3";
        T_I3.InputPlaceName.add("P_I3");
        T_I3.InputPlaceName.add("P_INT1");

        Condition TI3_inCt1 = new Condition(T_I3, "P_I3", TransitionCondition.NotNull);
        Condition TI3_inCt2 = new Condition(T_I3, "P_INT1", TransitionCondition.CanAddCars);
        TI3_inCt1.SetNextCondition(LogicConnector.AND, TI3_inCt2);

        GuardMapping grdTI3_in = new GuardMapping();
        grdTI3_in.condition = TI3_inCt1;
        grdTI3_in.Activations.add(new Activation(T_I3, "P_I3", TransitionOperation.AddElement, "P_INT1"));
        T_I3.GuardMappingList.add(grdTI3_in);

        T_I3.Delay = 0;
        pn.Transitions.add(T_I3);

        // T_O1-----------------------------------------------------------
        PetriTransition T_O1 = new PetriTransition(pn);
        T_O1.TransitionName = "T_O1";
        T_O1.InputPlaceName.add("P_INT1");
        T_O1.InputPlaceName.add("P_O1");

        Condition T_O1_Ct1 = new Condition(T_O1, "P_INT1", TransitionCondition.HaveCarForMe);
        Condition T_O1_Ct2 = new Condition(T_O1, "P_O1", TransitionCondition.CanAddCars);
        T_O1_Ct1.SetNextCondition(LogicConnector.AND, T_O1_Ct2);

        GuardMapping grdT_O1 = new GuardMapping();
        grdT_O1.condition = T_O1_Ct1;
        grdT_O1.Activations.add(new Activation(T_O1, "P_INT1", TransitionOperation.PopElementWithTargetToQueue, "P_O1"));
        T_O1.GuardMappingList.add(grdT_O1);

        T_O1.Delay = 0;
        pn.Transitions.add(T_O1);

        // --------------------------------------secondpart-------------------------------------------

        // T_I6 ------------------------------------------------
        PetriTransition T_I6 = new PetriTransition(pn);
        T_I6.TransitionName = "T_I6";
        T_I6.InputPlaceName.add("P_I6");
        T_I6.InputPlaceName.add("P_INT1");

        Condition T_I6_Ct1 = new Condition(T_I6, "P_I6", TransitionCondition.NotNull);
        Condition T_I6_Ct2 = new Condition(T_I6, "P_INT1", TransitionCondition.CanAddCars);
        T_I6_Ct1.SetNextCondition(LogicConnector.AND, T_I6_Ct2);

        GuardMapping grdT_I6 = new GuardMapping();
        grdT_I6.condition = T_I6_Ct1;
        grdT_I6.Activations.add(new Activation(T_I6, "P_I6", TransitionOperation.AddElement, "P_INT1"));
        T_I6.GuardMappingList.add(grdT_I6);

        T_I6.Delay = 0;
        pn.Transitions.add(T_I6);

        // T_O5-----------------------------------------------------------
        PetriTransition T_O3 = new PetriTransition(pn);
        T_O3.TransitionName = "T_O5";
        T_O3.InputPlaceName.add("P_INT1");
        T_O3.InputPlaceName.add("P_O3");

        Condition T_O3_Ct1 = new Condition(T_O3, "P_INT1", TransitionCondition.HaveCarForMe);
        Condition T_O3_Ct2 = new Condition(T_O3, "P_O3", TransitionCondition.CanAddCars);
        T_O3_Ct1.SetNextCondition(LogicConnector.AND, T_O3_Ct2);

        GuardMapping grdT_O3 = new GuardMapping();
        grdT_O3.condition = T_O3_Ct1;
        grdT_O3.Activations.add(new Activation(T_O3, "P_INT1", TransitionOperation.PopElementWithTargetToQueue, "P_O3"));
        T_O3.GuardMappingList.add(grdT_O3);

        T_O3.Delay = 0;
        pn.Transitions.add(T_O3);

        // --------------------------------------thirdpart-------------------------------------------

        // T_M1 ------------------------------------------------
        PetriTransition T_M1 = new PetriTransition(pn);
        T_M1.TransitionName = "T_M1";
        T_M1.InputPlaceName.add("P_M1");
        T_M1.InputPlaceName.add("P_INT1");

        Condition T_M1_Ct1 = new Condition(T_M1, "P_M1", TransitionCondition.NotNull);
        Condition T_M1_Ct2 = new Condition(T_M1, "P_INT1", TransitionCondition.CanAddCars);
        T_M1_Ct1.SetNextCondition(LogicConnector.AND, T_M1_Ct2);

        GuardMapping grdT_M1 = new GuardMapping();
        grdT_M1.condition = T_M1_Ct1;
        grdT_M1.Activations.add(new Activation(T_M1, "P_M1", TransitionOperation.AddElement, "P_INT1"));
        T_M1.GuardMappingList.add(grdT_M1);

        T_M1.Delay = 0;
        pn.Transitions.add(T_M1);

        // T_O5-----------------------------------------------------------
        PetriTransition T_O5 = new PetriTransition(pn);
        T_O5.TransitionName = "T_O5";
        T_O5.InputPlaceName.add("P_INT1");
        T_O5.InputPlaceName.add("P_O5");

        Condition T_O5_Ct1 = new Condition(T_O5, "P_INT1", TransitionCondition.HaveCarForMe);
        Condition T_O5_Ct2 = new Condition(T_O5, "P_O5", TransitionCondition.CanAddCars);
        T_O5_Ct1.SetNextCondition(LogicConnector.AND, T_O5_Ct2);

        GuardMapping grdT_O5 = new GuardMapping();
        grdT_O5.condition = T_O5_Ct1;
        grdT_O5.Activations.add(new Activation(T_O5, "P_INT1", TransitionOperation.PopElementWithTargetToQueue, "P_O5"));
        T_O5.GuardMappingList.add(grdT_O5);

        T_O5.Delay = 0;
        pn.Transitions.add(T_O5);

        // --------------------------------------fourthpart-------------------------------------------

        // T_M6 ------------------------------------------------
        PetriTransition T_M6 = new PetriTransition(pn);
        T_M6.TransitionName = "T_M6";
        T_M6.InputPlaceName.add("P_M4");
        T_M6.InputPlaceName.add("P_INT1");

        Condition T_M6_Ct1 = new Condition(T_M6, "P_M4", TransitionCondition.NotNull);
        Condition T_M6_Ct2 = new Condition(T_M6, "P_INT1", TransitionCondition.CanAddCars);
        T_M6_Ct1.SetNextCondition(LogicConnector.AND, T_M6_Ct2);

        GuardMapping grdT_M6 = new GuardMapping();
        grdT_M6.condition = T_M6_Ct1;
        grdT_M6.Activations.add(new Activation(T_M6, "P_M4", TransitionOperation.AddElement, "P_INT1"));
        T_M1.GuardMappingList.add(grdT_M1);

        T_M1.Delay = 0;
        pn.Transitions.add(T_M1);

        // T_O5-----------------------------------------------------------
//        PetriTransition T_O5 = new PetriTransition(pn);
        T_O5.TransitionName = "T_O5";
        T_O5.InputPlaceName.add("P_INT1");
        T_O5.InputPlaceName.add("P_O5");

        Condition T_O5_Ct3 = new Condition(T_O5, "P_INT1", TransitionCondition.HaveCarForMe);
        Condition T_O5_Ct4 = new Condition(T_O5, "P_O5", TransitionCondition.CanAddCars);
        T_O5_Ct3.SetNextCondition(LogicConnector.AND, T_O5_Ct4);

        GuardMapping grdT_O5_1 = new GuardMapping();
        grdT_O5_1.condition = T_O5_Ct3;
        grdT_O5_1.Activations.add(new Activation(T_O5, "P_INT1", TransitionOperation.PopElementWithTargetToQueue, "P_O5"));
        T_O5.GuardMappingList.add(grdT_O5);

        T_O5.Delay = 0;
        pn.Transitions.add(T_O5);

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
