package com.edge.seven.re.up.sticks.Controller;

import com.airbnb.epoxy.TypedEpoxyController;
import com.edge.seven.re.up.sticks.Interfaces.MMessage;
import com.edge.seven.re.up.sticks.Model.SingleDMModel_;

import java.util.List;

import static com.edge.seven.re.up.sticks.Helper.CONSTANTS.MS_REC;
import static com.edge.seven.re.up.sticks.Helper.CONSTANTS.MS_SENT;

public class SingleDMController extends TypedEpoxyController<List<MMessage>> {
    public interface AdapterCallbacks {

    }

    private AdapterCallbacks adapterCallbacks;

    public SingleDMController(AdapterCallbacks adapterCallbacks) {
        this.adapterCallbacks = adapterCallbacks;
    }

    @Override
    protected void buildModels(List<MMessage> data) {
        for (int i = 0; i < data.size(); i++) {
            new SingleDMModel_().id(data.get(i).getTime()).message(data.get(i).getMessage()).timeStamp(String.valueOf(data.get(i).getTime())).type(shit(i)).addTo(this);
        }
    }

    public int shit(int r)
    {
        if ((r % 2) == 0)
        {
            return MS_SENT;
        } else {
            return MS_REC;
        }
    }
}
