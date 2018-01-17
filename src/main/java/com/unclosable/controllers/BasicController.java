package com.unclosable.controllers;

import java.util.List;

import com.alibaba.fastjson.JSON;

public abstract class BasicController {
	public static int RESPONSE_CODE_SUCCESS = 200;

	protected class JsonRespons<T> {
		private int reCode = RESPONSE_CODE_SUCCESS;
		private T data;
		private List<T> dataList;
		private String reMessage;

		public JsonRespons() {
		}

		public JsonRespons(T data) {
			this.data = data;
		}

		public JsonRespons(List<T> dataList) {
			this.dataList = dataList;
		}

		public JsonRespons(String msg) {
			this.reMessage = msg;
		}

		public JsonRespons(T data, String msg) {
			this.reMessage = msg;
			this.data = data;
		}

		public JsonRespons(List<T> dataList, String msg) {
			this.reMessage = msg;
			this.dataList = dataList;
		}

		public int getReCode() {
			return reCode;
		}

		public void setReCode(int reCode) {
			this.reCode = reCode;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public List<T> getDataList() {
			return dataList;
		}

		public void setDataList(List<T> dataList) {
			this.dataList = dataList;
		}

		public String getReMessage() {
			return reMessage;
		}

		public void setReMessage(String reMessage) {
			this.reMessage = reMessage;
		}

		@Override
		public String toString() {
			return JSON.toJSONString(this);
		}
	}

}
