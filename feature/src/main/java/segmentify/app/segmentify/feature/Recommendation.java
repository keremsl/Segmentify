package segmentify.app.segmentify.feature;

import java.util.Date;

public class Recommendation {

    private Date _recoDate;
    private String _recoPageType,_recoName;
    private boolean _isRecoLive;
    private boolean _isRecoForDesktop;
    private boolean _isRecoForMobile;

    public Recommendation(Date _recoDate, String _recoPageType, String _recoName, boolean _isRecoLive, boolean _isRecoForDesktop, boolean _isRecoForMobile) {
        this._recoDate = _recoDate;
        this._recoPageType = _recoPageType;
        this._recoName = _recoName;
        this._isRecoLive = _isRecoLive;
        this._isRecoForDesktop = _isRecoForDesktop;
        this._isRecoForMobile = _isRecoForMobile;
    }

    public Recommendation(Date _recoDate, String _recoPageType, String _recoName) {
        this._recoDate = _recoDate;
        this._recoPageType = _recoPageType;
        this._recoName = _recoName;
    }

    public Date get_recoDate() {
        return _recoDate;
    }

    public String get_recoPageType() {
        return _recoPageType;
    }

    public String get_recoName() {
        return _recoName;
    }

    public boolean is_isRecoLive() {
        return _isRecoLive;
    }

    public boolean is_isRecoForDesktop() {
        return _isRecoForDesktop;
    }

    public boolean is_isRecoForMobile() {
        return _isRecoForMobile;
    }
}
