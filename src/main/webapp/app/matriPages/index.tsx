import React from 'react';
import { Switch } from 'react-router-dom';

import { AUTHORITIES } from 'app/config/constants';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Techno from './techno';

/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      hello
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}techno`} component={Techno}
        
      />
      
      {/* jhipster-needle-add-route-path - JHipster will add routes here */}
    </Switch>
  </div>
);

export default Routes;
