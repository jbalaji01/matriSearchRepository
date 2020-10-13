import React from 'react';
import axios from 'axios';




type MyProps = {  };
type MyState = {
  resultMarkup  : string };

class ParamCreator extends React.Component<MyProps, MyState> {

  apiUrl = 'api/param_creator';
  

  constructor(props) {
    super(props);
    this.state = { resultMarkup: '' };
  };

  upload(data) {
    return axios.post(this.apiUrl + "/upload", data);
  }

  onFileChangeHandler = (e) => {
    const formData = new FormData();
    // alert("num of files=" + e.target.files.length);

    for (let i = 0; i < e.target.files.length; i++) {
      formData.append('files', e.target.files[i])
    }

    // alert("formData length = " + formData.getAll.length);

    this.upload(formData)
      .then(res => {
        // console.log(res.data);
        this.setState({ resultMarkup: res.data });
        // alert("File uploaded successfully. " + res.data);
      })
  };

  render() {
    return (
      <div>
        <label>Upload Files</label>
        <input type="file" className="form-control" name="files"
          onChange={(event) => this.onFileChangeHandler(event)}
          multiple />

        <br />

        <div>
          {<div dangerouslySetInnerHTML={{ __html: this.state.resultMarkup }} />}
        </div>

      </div>
    );
  }
}


export default ParamCreator;
