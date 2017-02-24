package com.coolweather.android.gson;

import java.util.List;

/**
 * Created by huxiyang on 2017/2/22.
 */

public class Weather {

    /**
     * aqi : {"city":{"aqi":"55","co":"1","no2":"38","o3":"25","pm10":"0","pm25":"38","qlty":"良","so2":"11"}}
     * basic : {"city":"苏州","cnty":"中国","id":"CN101190401","lat":"31.309000","lon":"120.612000","update":{"loc":"2017-02-22 09:52","utc":"2017-02-22 01:52"}}
     * daily_forecast : [{"astro":{"mr":"03:04","ms":"13:49","sr":"06:31","ss":"17:50"},"cond":{"code_d":"305","code_n":"101","txt_d":"小雨","txt_n":"多云"},"date":"2017-02-22","hum":"84","pcpn":"4.3","pop":"100","pres":"1021","tmp":{"max":"8","min":"3"},"uv":"3","vis":"7","wind":{"deg":"306","dir":"西北风","sc":"3-4","spd":"15"}},{"astro":{"mr":"03:53","ms":"14:41","sr":"06:30","ss":"17:51"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2017-02-23","hum":"72","pcpn":"0.0","pop":"0","pres":"1029","tmp":{"max":"7","min":"2"},"uv":"5","vis":"10","wind":{"deg":"347","dir":"西北风","sc":"3-4","spd":"13"}},{"astro":{"mr":"04:39","ms":"15:37","sr":"06:29","ss":"17:51"},"cond":{"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"},"date":"2017-02-24","hum":"59","pcpn":"0.0","pop":"0","pres":"1030","tmp":{"max":"10","min":"2"},"uv":"6","vis":"10","wind":{"deg":"318","dir":"北风","sc":"3-4","spd":"14"}}]
     * hourly_forecast : [{"cond":{"code":"305","txt":"小雨"},"date":"2017-02-22 10:00","hum":"83","pop":"97","pres":"1021","tmp":"7","wind":{"deg":"304","dir":"西北风","sc":"4-5","spd":"29"}},{"cond":{"code":"309","txt":"毛毛雨/细雨"},"date":"2017-02-22 13:00","hum":"81","pop":"98","pres":"1021","tmp":"9","wind":{"deg":"306","dir":"西北风","sc":"4-5","spd":"30"}},{"cond":{"code":"309","txt":"毛毛雨/细雨"},"date":"2017-02-22 16:00","hum":"81","pop":"95","pres":"1021","tmp":"9","wind":{"deg":"308","dir":"西北风","sc":"3-4","spd":"27"}},{"cond":{"code":"305","txt":"小雨"},"date":"2017-02-22 19:00","hum":"80","pop":"67","pres":"1023","tmp":"7","wind":{"deg":"310","dir":"西北风","sc":"3-4","spd":"24"}},{"cond":{"code":"305","txt":"小雨"},"date":"2017-02-22 22:00","hum":"80","pop":"51","pres":"1025","tmp":"6","wind":{"deg":"310","dir":"西北风","sc":"3-4","spd":"23"}}]
     * now : {"cond":{"code":"101","txt":"多云"},"fl":"0","hum":"90","pcpn":"0.2","pres":"1019","tmp":"6","vis":"10","wind":{"deg":"292","dir":"西风","sc":"5-6","spd":"30"}}
     * status : ok
     * suggestion : {"air":{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"},"comf":{"brf":"较舒适","txt":"白天会有降雨，这种天气条件下，人们会感到有些凉意，但大部分人完全可以接受。"},"cw":{"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"drsg":{"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"},"flu":{"brf":"易发","txt":"昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"},"sport":{"brf":"较不宜","txt":"有降水，且风力较强，推荐您在室内进行低强度运动；若坚持户外运动，请注意保暖并携带雨具。"},"trav":{"brf":"一般","txt":"天气稍凉，风稍大会加大些凉意，且预报有降水，旅游指数一般，外出旅游请注意防风保暖并携带雨具。"},"uv":{"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}}
     */

    private AqiBean aqi;
    private BasicBean basic;
    private NowBean now;
    private String status;
    private SuggestionBean suggestion;
    private List<DailyForecastBean> daily_forecast;
    private List<HourlyForecastBean> hourly_forecast;

    public AqiBean getAqi() {
        return aqi;
    }

    public void setAqi(AqiBean aqi) {
        this.aqi = aqi;
    }

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SuggestionBean getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionBean suggestion) {
        this.suggestion = suggestion;
    }

    public List<DailyForecastBean> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public List<HourlyForecastBean> getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }

    public static class AqiBean {
        /**
         * city : {"aqi":"55","co":"1","no2":"38","o3":"25","pm10":"0","pm25":"38","qlty":"良","so2":"11"}
         */

        private CityBean city;

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public static class CityBean {
            /**
             * aqi : 55
             * co : 1
             * no2 : 38
             * o3 : 25
             * pm10 : 0
             * pm25 : 38
             * qlty : 良
             * so2 : 11
             */

            private String aqi;
            private String co;
            private String no2;
            private String o3;
            private String pm10;
            private String pm25;
            private String qlty;
            private String so2;

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public String getQlty() {
                return qlty;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }
        }
    }

    public static class BasicBean {
        /**
         * city : 苏州
         * cnty : 中国
         * id : CN101190401
         * lat : 31.309000
         * lon : 120.612000
         * update : {"loc":"2017-02-22 09:52","utc":"2017-02-22 01:52"}
         */

        private String city;
        private String cnty;
        private String id;
        private String lat;
        private String lon;
        private UpdateBean update;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCnty() {
            return cnty;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public static class UpdateBean {
            /**
             * loc : 2017-02-22 09:52
             * utc : 2017-02-22 01:52
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }
    }

    public static class NowBean {
        /**
         * cond : {"code":"101","txt":"多云"}
         * fl : 0
         * hum : 90
         * pcpn : 0.2
         * pres : 1019
         * tmp : 6
         * vis : 10
         * wind : {"deg":"292","dir":"西风","sc":"5-6","spd":"30"}
         */

        private CondBean cond;
        private String fl;
        private String hum;
        private String pcpn;
        private String pres;
        private String tmp;
        private String vis;
        private WindBean wind;

        public CondBean getCond() {
            return cond;
        }

        public void setCond(CondBean cond) {
            this.cond = cond;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public static class CondBean {
            /**
             * code : 101
             * txt : 多云
             */

            private String code;
            private String txt;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class WindBean {
            /**
             * deg : 292
             * dir : 西风
             * sc : 5-6
             * spd : 30
             */

            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }

    public static class SuggestionBean {
        /**
         * air : {"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}
         * comf : {"brf":"较舒适","txt":"白天会有降雨，这种天气条件下，人们会感到有些凉意，但大部分人完全可以接受。"}
         * cw : {"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"}
         * drsg : {"brf":"冷","txt":"天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"}
         * flu : {"brf":"易发","txt":"昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"}
         * sport : {"brf":"较不宜","txt":"有降水，且风力较强，推荐您在室内进行低强度运动；若坚持户外运动，请注意保暖并携带雨具。"}
         * trav : {"brf":"一般","txt":"天气稍凉，风稍大会加大些凉意，且预报有降水，旅游指数一般，外出旅游请注意防风保暖并携带雨具。"}
         * uv : {"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}
         */

        private AirBean air;
        private ComfBean comf;
        private CwBean cw;
        private DrsgBean drsg;
        private FluBean flu;
        private SportBean sport;
        private TravBean trav;
        private UvBean uv;

        public AirBean getAir() {
            return air;
        }

        public void setAir(AirBean air) {
            this.air = air;
        }

        public ComfBean getComf() {
            return comf;
        }

        public void setComf(ComfBean comf) {
            this.comf = comf;
        }

        public CwBean getCw() {
            return cw;
        }

        public void setCw(CwBean cw) {
            this.cw = cw;
        }

        public DrsgBean getDrsg() {
            return drsg;
        }

        public void setDrsg(DrsgBean drsg) {
            this.drsg = drsg;
        }

        public FluBean getFlu() {
            return flu;
        }

        public void setFlu(FluBean flu) {
            this.flu = flu;
        }

        public SportBean getSport() {
            return sport;
        }

        public void setSport(SportBean sport) {
            this.sport = sport;
        }

        public TravBean getTrav() {
            return trav;
        }

        public void setTrav(TravBean trav) {
            this.trav = trav;
        }

        public UvBean getUv() {
            return uv;
        }

        public void setUv(UvBean uv) {
            this.uv = uv;
        }

        public static class AirBean {
            /**
             * brf : 中
             * txt : 气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class ComfBean {
            /**
             * brf : 较舒适
             * txt : 白天会有降雨，这种天气条件下，人们会感到有些凉意，但大部分人完全可以接受。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class CwBean {
            /**
             * brf : 不宜
             * txt : 不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class DrsgBean {
            /**
             * brf : 冷
             * txt : 天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class FluBean {
            /**
             * brf : 易发
             * txt : 昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class SportBean {
            /**
             * brf : 较不宜
             * txt : 有降水，且风力较强，推荐您在室内进行低强度运动；若坚持户外运动，请注意保暖并携带雨具。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class TravBean {
            /**
             * brf : 一般
             * txt : 天气稍凉，风稍大会加大些凉意，且预报有降水，旅游指数一般，外出旅游请注意防风保暖并携带雨具。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class UvBean {
            /**
             * brf : 最弱
             * txt : 属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
             */

            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }
    }

    public static class DailyForecastBean {
        /**
         * astro : {"mr":"03:04","ms":"13:49","sr":"06:31","ss":"17:50"}
         * cond : {"code_d":"305","code_n":"101","txt_d":"小雨","txt_n":"多云"}
         * date : 2017-02-22
         * hum : 84
         * pcpn : 4.3
         * pop : 100
         * pres : 1021
         * tmp : {"max":"8","min":"3"}
         * uv : 3
         * vis : 7
         * wind : {"deg":"306","dir":"西北风","sc":"3-4","spd":"15"}
         */

        private AstroBean astro;
        private CondBeanX cond;
        private String date;
        private String hum;
        private String pcpn;
        private String pop;
        private String pres;
        private TmpBean tmp;
        private String uv;
        private String vis;
        private WindBeanX wind;

        public AstroBean getAstro() {
            return astro;
        }

        public void setAstro(AstroBean astro) {
            this.astro = astro;
        }

        public CondBeanX getCond() {
            return cond;
        }

        public void setCond(CondBeanX cond) {
            this.cond = cond;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public TmpBean getTmp() {
            return tmp;
        }

        public void setTmp(TmpBean tmp) {
            this.tmp = tmp;
        }

        public String getUv() {
            return uv;
        }

        public void setUv(String uv) {
            this.uv = uv;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public WindBeanX getWind() {
            return wind;
        }

        public void setWind(WindBeanX wind) {
            this.wind = wind;
        }

        public static class AstroBean {
            /**
             * mr : 03:04
             * ms : 13:49
             * sr : 06:31
             * ss : 17:50
             */

            private String mr;
            private String ms;
            private String sr;
            private String ss;

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }
        }

        public static class CondBeanX {
            /**
             * code_d : 305
             * code_n : 101
             * txt_d : 小雨
             * txt_n : 多云
             */

            private String code_d;
            private String code_n;
            private String txt_d;
            private String txt_n;

            public String getCode_d() {
                return code_d;
            }

            public void setCode_d(String code_d) {
                this.code_d = code_d;
            }

            public String getCode_n() {
                return code_n;
            }

            public void setCode_n(String code_n) {
                this.code_n = code_n;
            }

            public String getTxt_d() {
                return txt_d;
            }

            public void setTxt_d(String txt_d) {
                this.txt_d = txt_d;
            }

            public String getTxt_n() {
                return txt_n;
            }

            public void setTxt_n(String txt_n) {
                this.txt_n = txt_n;
            }
        }

        public static class TmpBean {
            /**
             * max : 8
             * min : 3
             */

            private String max;
            private String min;

            public String getMax() {
                return max;
            }

            public void setMax(String max) {
                this.max = max;
            }

            public String getMin() {
                return min;
            }

            public void setMin(String min) {
                this.min = min;
            }
        }

        public static class WindBeanX {
            /**
             * deg : 306
             * dir : 西北风
             * sc : 3-4
             * spd : 15
             */

            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }

    public static class HourlyForecastBean {
        /**
         * cond : {"code":"305","txt":"小雨"}
         * date : 2017-02-22 10:00
         * hum : 83
         * pop : 97
         * pres : 1021
         * tmp : 7
         * wind : {"deg":"304","dir":"西北风","sc":"4-5","spd":"29"}
         */

        private CondBeanXX cond;
        private String date;
        private String hum;
        private String pop;
        private String pres;
        private String tmp;
        private WindBeanXX wind;

        public CondBeanXX getCond() {
            return cond;
        }

        public void setCond(CondBeanXX cond) {
            this.cond = cond;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public WindBeanXX getWind() {
            return wind;
        }

        public void setWind(WindBeanXX wind) {
            this.wind = wind;
        }

        public static class CondBeanXX {
            /**
             * code : 305
             * txt : 小雨
             */

            private String code;
            private String txt;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class WindBeanXX {
            /**
             * deg : 304
             * dir : 西北风
             * sc : 4-5
             * spd : 29
             */

            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }
}
